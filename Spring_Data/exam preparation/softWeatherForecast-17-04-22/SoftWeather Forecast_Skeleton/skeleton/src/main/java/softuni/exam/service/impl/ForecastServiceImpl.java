package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.ForecastImportDto;
import softuni.exam.models.dto.ForecastsRootDto;
import softuni.exam.models.entity.City;
import softuni.exam.models.entity.Forecast;
import softuni.exam.repository.CityRepository;
import softuni.exam.repository.ForecastRepository;
import softuni.exam.service.ForecastService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@Service
public class ForecastServiceImpl implements ForecastService {

    private static final String FORECAST_FILE_PATH = "src/main/resources/files/xml/forecasts.xml";
    private final ForecastRepository forecastRepository;
    private final CityRepository cityRepository;
    private final XmlParser xmlParser;
    private final ValidationUtil validationUtil;

    private final ModelMapper modelMapper;

    public ForecastServiceImpl(ForecastRepository forecastRepository, CityRepository cityRepository, XmlParser xmlParser, ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.forecastRepository = forecastRepository;
        this.cityRepository = cityRepository;
        this.xmlParser = xmlParser;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return forecastRepository.count() > 0;
    }

    @Override
    public String readForecastsFromFile() throws IOException {
        return Files.readString(Path.of(FORECAST_FILE_PATH));
    }

    @Override
    public String importForecasts() throws IOException, JAXBException {
        StringBuilder builder = new StringBuilder();

        ForecastsRootDto forecastsRootDto = xmlParser.fromFile(FORECAST_FILE_PATH, ForecastsRootDto.class);
        List<ForecastImportDto> forecastImportDtoList = forecastsRootDto.getForecasts();

        for (ForecastImportDto forecastImportDto : forecastImportDtoList) {

            if(!validationUtil.isValid(forecastImportDto) || forecastRepository.findByDayOfWeekAndAndCity(forecastImportDto.getDayOfWeek(),
                    cityRepository.getById(forecastImportDto.getCity())) != null){
                builder.append("Invalid forecast")
                        .append(System.lineSeparator());

            } else {
                Forecast forecast = modelMapper.map(forecastImportDto, Forecast.class);
                City city = cityRepository.getById(forecastImportDto.getCity());
                forecast.setCity(city);
                forecastRepository.save(forecast);

                builder.append(String.format("Successfully import forecast %s - %.2f",
                        forecast.getDayOfWeek(),
                        forecast.getMaxTemperature()))
                        .append(System.lineSeparator());

            }
        }

        return builder.toString().trim();
    }

    @Override
    public String exportForecasts() {
        StringBuilder builder = new StringBuilder();
        List<Forecast> forecastList = forecastRepository.findForecastFromSundayAndCitiesWithLessCitizensThan();

        for (Forecast forecast : forecastList) {
            builder.append(String.format("City: %s:\n" +
                    "   \t\t-min temperature: %.2f\n" +
                    "   \t\t--max temperature: %.2f\n" +
                    "   \t\t---sunrise: %s\n" +
                    "   \t\t----sunset: %s\n",
                            forecast.getCity().getCityName(),
                            forecast.getMinTemperature(),
                            forecast.getMaxTemperature(),
                            forecast.getSunrise(),
                            forecast.getSunset()))
                    .append(System.lineSeparator());

        }

        return builder.toString().trim();
    }
}
