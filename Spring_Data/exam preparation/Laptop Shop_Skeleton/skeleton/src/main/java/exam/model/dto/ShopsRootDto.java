package exam.model.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "shops")
@XmlAccessorType(XmlAccessType.FIELD)
public class ShopsRootDto {

    @XmlElement(name = "shop")
    private List<ShopsImportDto> shops;


    public List<ShopsImportDto> getShops() {
        return shops;
    }

    public void setShops(List<ShopsImportDto> shops) {
        this.shops = shops;
    }
}
