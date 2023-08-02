package softuni.exam;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import softuni.exam.service.CityService;
import softuni.exam.service.CountryService;
import softuni.exam.service.ForecastService;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    private final CountryService countryService;
    private final CityService cityService;
    private final ForecastService forecastService;

    public CommandLineRunnerImpl(CountryService countryService, CityService cityService, ForecastService forecastService) {
        this.countryService = countryService;
        this.cityService = cityService;
        this.forecastService = forecastService;
    }

    @Override
    public void run(String... args) throws Exception {


        if(!countryService.areImported()) {
            System.out.println(countryService.importCountries());
        }

        if(!cityService.areImported()) {
            System.out.println(cityService.importCities());
        }

        if(!forecastService.areImported()) {
            System.out.println(forecastService.importForecasts());
        }

        System.out.println(forecastService.exportForecasts());

    }
}
