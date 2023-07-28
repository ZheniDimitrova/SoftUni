package exam.model.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "towns")
@XmlAccessorType(XmlAccessType.FIELD)
public class TownsRootDto {
    @XmlElement(name = "town")
    List<TownsImportDto> towns;

    public List<TownsImportDto> getTowns() {
        return towns;
    }

    public void setTowns(List<TownsImportDto> towns) {
        this.towns = towns;
    }
}
