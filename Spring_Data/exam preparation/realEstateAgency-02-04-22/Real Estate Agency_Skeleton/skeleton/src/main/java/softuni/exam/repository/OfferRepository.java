package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.exam.models.entity.Offer;

import java.util.List;

@Repository
public interface OfferRepository extends JpaRepository<Offer, Long> {
    @Query("select o from Offer o join o.apartment as a where a.apartmentType = 'three_rooms' order by a.area desc, o.price")
    List<Offer> findOrderedOffers();

}
