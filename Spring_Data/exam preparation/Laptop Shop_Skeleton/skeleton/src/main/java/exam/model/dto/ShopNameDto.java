package exam.model.dto;

import com.google.gson.annotations.Expose;

import javax.validation.constraints.NotNull;

public class ShopNameDto {
    @Expose
    @NotNull
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
