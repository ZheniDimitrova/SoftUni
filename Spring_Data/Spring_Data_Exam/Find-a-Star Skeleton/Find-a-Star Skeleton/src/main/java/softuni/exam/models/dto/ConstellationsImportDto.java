package softuni.exam.models.dto;

import com.google.gson.annotations.Expose;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ConstellationsImportDto {
    @Expose
    @Size(min = 3, max = 20)
    @NotNull
    private String name;
    @Expose
    @Size(min = 5)
    @NotNull
    private String description;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}