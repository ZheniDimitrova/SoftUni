package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.CitiesImportDto;
import softuni.exam.models.entity.City;
import softuni.exam.models.entity.Country;
import softuni.exam.repository.CityRepository;
import softuni.exam.repository.CountryRepository;
import softuni.exam.service.CityService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


@Service
public class CityServiceImpl implements CityService {

    private static final String CITY_FILE_PATH = "src/main/resources/files/json/cities.json";

    private final CityRepository cityRepository;
    private final CountryRepository countryRepository;
    private final ModelMapper modelMapper;
    private final Gson gson;

    private final ValidationUtil validationUtil;

    public CityServiceImpl(CityRepository cityRepository, CountryRepository countryRepository, ModelMapper modelMapper, Gson gson, ValidationUtil validationUtil) {
        this.cityRepository = cityRepository;
        this.countryRepository = countryRepository;
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.validationUtil = validationUtil;
    }


    @Override
    public boolean areImported() {
        return cityRepository.count() > 0;
    }

    @Override
    public String readCitiesFileContent() throws IOException {
        return Files.readString(Path.of(CITY_FILE_PATH));
    }

    @Override
    public String importCities() throws IOException {
        StringBuilder builder = new StringBuilder();

        CitiesImportDto[] citiesImportDtoS = gson.fromJson(readCitiesFileContent(), CitiesImportDto[].class);

        for(CitiesImportDto citiesImportDto : citiesImportDtoS) {
            if(!validationUtil.isValid(citiesImportDto) || cityRepository.findByCityName(citiesImportDto.getCityName()) != null) {
                builder.append("Invalid city")
                        .append(System.lineSeparator());

            } else {
                City city = modelMapper.map(citiesImportDto, City.class);
                Country country = countryRepository.findById(citiesImportDto.getCountry()).get();
                city.setCountry(country);
                cityRepository.save(city);

                builder.append(String.format("Successfully imported city %s - %d",
                        city.getCityName(),
                        city.getPopulation()))
                        .append(System.lineSeparator());

            }
        }

        return builder.toString().trim();
    }
}
