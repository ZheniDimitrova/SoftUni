package exam.model.dto;

import com.google.gson.annotations.Expose;
import exam.model.entity.WarrantyType;

import javax.persistence.Enumerated;
import javax.validation.constraints.*;
import java.math.BigDecimal;

public class LaptopsImportDto {
    @Expose
    @Size(min = 9)
    @NotNull
    private String macAddress;

    @Expose
    @Positive
    @NotNull
    private double cpuSpeed;
    @Expose
    @Min(8)
    @Max(128)
    @NotNull
    private int ram;

    @Expose
    @Min(128)
    @Max(1024)
    @NotNull
    private int storage;
    @Expose
    @Size(min = 10)
    @NotNull
    private String description;
    @Expose
    @Positive
    @NotNull
    private BigDecimal price;
    @Expose
    @Enumerated
    @NotNull
    private WarrantyType warrantyType;
    @Expose
    @NotNull
    private ShopNameDto shop;


    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    public double getCpuSpeed() {
        return cpuSpeed;
    }

    public void setCpuSpeed(double cpuSpeed) {
        this.cpuSpeed = cpuSpeed;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getStorage() {
        return storage;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public WarrantyType getWarrantyType() {
        return warrantyType;
    }

    public void setWarrantyType(WarrantyType warrantyType) {
        this.warrantyType = warrantyType;
    }

    public ShopNameDto getShop() {
        return shop;
    }

    public void setShop(ShopNameDto shop) {
        this.shop = shop;
    }
}
