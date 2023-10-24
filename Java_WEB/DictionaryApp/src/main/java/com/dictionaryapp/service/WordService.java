package com.dictionaryapp.service;

import com.dictionaryapp.model.dto.WordExportDto;
import com.dictionaryapp.model.entity.enums.LanguageEnum;
import com.dictionaryapp.validation.WordBindingModel;

import java.util.List;

public interface WordService {
    void addWord(WordBindingModel wordBindingModel);

    List<WordExportDto> wordListByLanguage(LanguageEnum language);

    void deleteWordById(Long id);

    void deleteAll();
}
