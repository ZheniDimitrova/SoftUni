package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.exam.models.entity.Task;

import java.util.List;

@Repository
public interface TasksRepository extends JpaRepository<Task, Long> {
    @Query("select t from Task t join t.car c where c.carType = 'coupe' order by t.price desc ")
    List<Task> findAllByCarTypeCoupeOrderByPriceDesc();

}
