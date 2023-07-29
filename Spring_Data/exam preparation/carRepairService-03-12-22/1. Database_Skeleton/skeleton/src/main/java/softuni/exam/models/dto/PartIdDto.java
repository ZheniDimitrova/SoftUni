package softuni.exam.models.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "part")
@XmlAccessorType(XmlAccessType.FIELD)
public class PartIdDto {
    @XmlElement(name = "id")
    private  long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
