package com.dictionaryapp.model.entity;

import com.dictionaryapp.model.entity.enums.LanguageEnum;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "languages")
public class Language extends BaseEntity{
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private LanguageEnum name;
    @Column(nullable = false)
    private String description;
    @OneToMany(mappedBy = "language")
    private Set<Word> words;

    public Language() {
    }

    public LanguageEnum getName() {
        return name;
    }

    public void setName(LanguageEnum name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Word> getWords() {
        return words;
    }

    public void setWords(Set<Word> words) {
        this.words = words;
    }
}
