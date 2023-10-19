package com.likebookapp.model.binding;

import com.likebookapp.model.entity.enums.MoodNameEnum;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class PostBindingModel {

    private Long id;
    @Size(min = 2, max = 50, message = "Content length must be between 2 and 50 characters!")
    private String content;
    @NotNull(message = "You must select mood!")
    private MoodNameEnum mood;

    public PostBindingModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public MoodNameEnum getMood() {
        return mood;
    }

    public void setMood(MoodNameEnum mood) {
        this.mood = mood;
    }
}
