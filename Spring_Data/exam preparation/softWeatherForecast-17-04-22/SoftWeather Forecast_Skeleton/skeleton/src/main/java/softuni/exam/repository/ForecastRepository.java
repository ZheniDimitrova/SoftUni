package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.exam.models.entity.City;
import softuni.exam.models.entity.DayOfWeek;
import softuni.exam.models.entity.Forecast;

import java.util.List;

@Repository
public interface ForecastRepository extends JpaRepository<Forecast, Long> {

    Forecast findByDayOfWeekAndAndCity(DayOfWeek dayOfWeek, City city);

    @Query("select f from Forecast as f join f.city as c where f.dayOfWeek = 'SUNDAY' and c.population < 150000 order by f.maxTemperature desc, f.id")
    List<Forecast> findForecastFromSundayAndCitiesWithLessCitizensThan();

}
