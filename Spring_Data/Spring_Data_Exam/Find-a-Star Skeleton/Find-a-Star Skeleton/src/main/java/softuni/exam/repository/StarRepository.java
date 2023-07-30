package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.exam.models.entity.Star;

import java.util.List;

@Repository
public interface StarRepository extends JpaRepository<Star, Long> {

    Star findByName(String name);
    @Query("select s from Star s  where s.starType = 'RED_GIANT' and size(s.astronomers) = 0 order by s.lightYears")
    List<Star> findTheNonObservedStars();

}
