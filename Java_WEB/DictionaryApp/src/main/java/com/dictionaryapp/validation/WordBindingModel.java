package com.dictionaryapp.validation;


import com.dictionaryapp.model.entity.enums.LanguageEnum;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class WordBindingModel {

    private Long id;

    @Size(min = 2, max = 40, message = "Term length must be between 2 and 40 characters ")
    private String term;

    @Size(min = 2, max = 80, message = "Translation length must be between 2 and 80 characters ")
    private String translation;
    @Size(min = 2, max = 200, message = "Example length must be between 2 and 200 characters ")
    private String example;

    @PastOrPresent(message = "The input date must be a date in the past or present")
    private LocalDate inputDate;
    @NotNull(message = "You must select a language")
    private LanguageEnum language;

    public WordBindingModel() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    public String getExample() {
        return example;
    }

    public void setExample(String example) {
        this.example = example;
    }

    public LocalDate getInputDate() {
        return inputDate;
    }

    public void setInputDate(LocalDate inputDate) {
        this.inputDate = inputDate;
    }

    public LanguageEnum getLanguage() {
        return language;
    }

    public void setLanguage(LanguageEnum language) {
        this.language = language;
    }
}
