package softuni.exam.models.dto;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.*;
import java.math.BigDecimal;

@XmlRootElement(name = "offer")
@XmlAccessorType(XmlAccessType.FIELD)
public class OfferImportDto {
    @XmlElement
    @NotNull
    private BigDecimal price;

    @XmlElement
    @NotNull
    private AgentNameDto agent;

    @XmlElement
    @NotNull
    private ApartmentIdDto apartment;
    @XmlElement
    @NotNull
    private String publishedOn;


    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public AgentNameDto getAgent() {
        return agent;
    }

    public void setAgent(AgentNameDto agent) {
        this.agent = agent;
    }

    public ApartmentIdDto getApartment() {
        return apartment;
    }

    public void setApartment(ApartmentIdDto apartment) {
        this.apartment = apartment;
    }

    public String getPublishedOn() {
        return publishedOn;
    }

    public void setPublishedOn(String publishedOn) {
        this.publishedOn = publishedOn;
    }
}
