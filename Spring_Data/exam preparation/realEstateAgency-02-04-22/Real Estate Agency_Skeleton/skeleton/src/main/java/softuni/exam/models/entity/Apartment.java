package softuni.exam.models.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "apartments")
public class Apartment extends BaseEntity{

    private ApartmentType apartmentType;

    private double area;

    private Town town;

    private Set<Offer> offers;

    public Apartment() {
    }
    @Column(name = "apartment_type", nullable = false)
    @Enumerated(EnumType.STRING)
    public ApartmentType getApartmentType() {
        return apartmentType;
    }

    public void setApartmentType(ApartmentType apartmentType) {
        this.apartmentType = apartmentType;
    }
    @Column(nullable = false)
    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }
    @ManyToOne
    public Town getTown() {
        return town;
    }

    public void setTown(Town town) {
        this.town = town;
    }
    @OneToMany(mappedBy = "apartment")
    public Set<Offer> getOffers() {
        return offers;
    }

    public void setOffers(Set<Offer> offers) {
        this.offers = offers;
    }
}
