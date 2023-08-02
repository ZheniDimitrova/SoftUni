package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.CountriesImportDto;
import softuni.exam.models.entity.Country;
import softuni.exam.repository.CountryRepository;
import softuni.exam.service.CountryService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class CountryServiceImpl implements CountryService {

    private static final String COUNTRY_FILE_PATH = "src/main/resources/files/json/countries.json";

    private final CountryRepository countryRepository;
    private final Gson gson;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;

    public CountryServiceImpl(CountryRepository countryRepository, Gson gson, ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.countryRepository = countryRepository;
        this.gson = gson;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return countryRepository.count() > 0;
    }

    @Override
    public String readCountriesFromFile() throws IOException {
        return Files.readString(Path.of(COUNTRY_FILE_PATH));
    }

    @Override
    public String importCountries() throws IOException {
        StringBuilder builder = new StringBuilder();

        CountriesImportDto[] countriesImportDtoS = gson.fromJson(readCountriesFromFile(), CountriesImportDto[].class);

        for(CountriesImportDto countriesImportDto : countriesImportDtoS) {

            if(!validationUtil.isValid(countriesImportDto) || countryRepository.findByCountryName(countriesImportDto.getCountryName()) != null) {
                builder.append("Invalid country")
                        .append(System.lineSeparator());

            } else {
                Country country = modelMapper.map(countriesImportDto, Country.class);
                countryRepository.save(country);

                builder.append(String.format("Successfully imported country %s - %s",
                        country.getCities(),
                        country.getCurrency()))
                        .append(System.lineSeparator());
            }
        }


        return builder.toString().trim();
    }
}
