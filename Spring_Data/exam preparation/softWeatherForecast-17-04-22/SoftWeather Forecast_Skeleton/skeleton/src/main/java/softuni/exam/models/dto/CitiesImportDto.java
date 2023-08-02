package softuni.exam.models.dto;

import com.google.gson.annotations.Expose;


import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CitiesImportDto {
    @Expose
    private String cityName;
    @Expose
    private String description;
    @Expose
    private int population;
    @Expose
    private long country;

    @Size(min = 2, max = 60)
    @NotNull
    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
    @Size(min = 2)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    @Min(500)
    @NotNull
    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }
    @NotNull
    public long getCountry() {
        return country;
    }

    public void setCountry(long country) {
        this.country = country;
    }
}
