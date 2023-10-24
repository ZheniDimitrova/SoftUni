package com.dictionaryapp.init;

import com.dictionaryapp.repo.LanguageRepository;
import com.dictionaryapp.service.LanguageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DbInit implements CommandLineRunner {

    private final LanguageService languageService;

    public DbInit(LanguageService languageService) {
        this.languageService = languageService;
    }


    @Override
    public void run(String... args) throws Exception {

        languageService.initLanguage();
    }
}
