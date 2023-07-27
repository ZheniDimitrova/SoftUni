package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.exam.models.entity.Apartment;

@Repository
public interface ApartmentRepository extends JpaRepository<Apartment, Long> {
    @Query("select a from Apartment a join a.town as t where t.townName = :name and a.area = :area")
    Apartment findByTownNameAndArea(String name, double area);

}
