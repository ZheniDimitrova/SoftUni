package exam.repository;

import exam.model.entity.Laptop;
import exam.model.entity.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface LaptopRepository extends JpaRepository<Laptop, Long> {

    Laptop findByMacAddress(String macAddress);
    @Query("select l from Laptop l join l.shop s join s.town t order by l.cpuSpeed desc, l.storage desc, l.macAddress")
    List<Laptop> findBestLaptops();
}
