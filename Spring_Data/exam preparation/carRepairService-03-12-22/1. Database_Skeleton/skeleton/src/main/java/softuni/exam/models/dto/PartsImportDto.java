package softuni.exam.models.dto;

import com.google.gson.annotations.Expose;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class PartsImportDto {
    @Expose
    private String partName;
    @Expose
    private double price;
    @Expose
    private int quantity;
    @Size(min = 2, max = 19)
    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }
    @DecimalMin("10")
    @DecimalMax("2000")
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    @Positive
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
