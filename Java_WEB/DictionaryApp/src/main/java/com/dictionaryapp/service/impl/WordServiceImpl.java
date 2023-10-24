package com.dictionaryapp.service.impl;

import com.dictionaryapp.model.dto.WordExportDto;
import com.dictionaryapp.model.entity.Language;
import com.dictionaryapp.model.entity.User;
import com.dictionaryapp.model.entity.Word;
import com.dictionaryapp.model.entity.enums.LanguageEnum;
import com.dictionaryapp.model.sec.CurrentUser;
import com.dictionaryapp.repo.LanguageRepository;
import com.dictionaryapp.repo.UserRepository;
import com.dictionaryapp.repo.WordRepository;
import com.dictionaryapp.service.WordService;
import com.dictionaryapp.validation.WordBindingModel;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WordServiceImpl implements WordService {
    private final WordRepository wordRepository;
    private final LanguageRepository languageRepository;
    private final UserRepository userRepository;
    private final CurrentUser currentUser;
    private final ModelMapper modelMapper;

    public WordServiceImpl(WordRepository wordRepository, LanguageRepository languageRepository, UserRepository userRepository, CurrentUser currentUser, ModelMapper modelMapper) {
        this.wordRepository = wordRepository;
        this.languageRepository = languageRepository;
        this.userRepository = userRepository;
        this.currentUser = currentUser;
        this.modelMapper = modelMapper;
    }

    @Override
    public void addWord(WordBindingModel wordBindingModel) {

        User user = userRepository.findByUsername(currentUser.getUsername());
        Word word = modelMapper.map(wordBindingModel, Word.class);
        Language language = languageRepository.findByName(wordBindingModel.getLanguage());

        word.setLanguage(language);
        word.setAddedBy(user);

        wordRepository.save(word);
    }

    @Override
    public List<WordExportDto> wordListByLanguage(LanguageEnum language) {
        List<Word> wordsList = wordRepository.findAllWordsByLanguage(language);

        List<WordExportDto> wordExportDtoS = new ArrayList<>();

        for (Word w : wordsList) {
            WordExportDto wordExportDto = modelMapper.map(w, WordExportDto.class);
            wordExportDto.setName(w.getAddedBy().getUsername());
            wordExportDto.setId(w.getId());

            wordExportDtoS.add(wordExportDto);

        }
        return wordExportDtoS;
    }

    @Override
    public void deleteWordById(Long id) {
        wordRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        wordRepository.deleteAll();
    }
}
