package softuni.exam.models.dto;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "astronomers")
@XmlAccessorType(XmlAccessType.FIELD)
public class AstronomersRootDto {

    @XmlElement(name = "astronomer")
    private List<AstronomersImportDto> astronomers;

    public List<AstronomersImportDto> getAstronomers() {
        return astronomers;
    }

    public void setAstronomers(List<AstronomersImportDto> astronomers) {
        this.astronomers = astronomers;
    }
}
