package com.dictionaryapp.model.dto;

import com.dictionaryapp.model.entity.Language;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;

import java.time.LocalDate;

public class WordExportDto {

    private Long id;
    private String term;

    private String translation;

    private String example;

    private LocalDate inputDate;

    private String name;

    public WordExportDto() {
    }

    public String getTerm() {
        return term;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
