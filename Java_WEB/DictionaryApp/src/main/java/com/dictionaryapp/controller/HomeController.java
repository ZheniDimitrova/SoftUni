package com.dictionaryapp.controller;

import com.dictionaryapp.model.dto.WordExportDto;
import com.dictionaryapp.model.entity.enums.LanguageEnum;
import com.dictionaryapp.model.sec.CurrentUser;
import com.dictionaryapp.service.WordService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    private final CurrentUser currentUser;
    private final WordService wordService;

    public HomeController(CurrentUser currentUser, WordService wordService) {
        this.currentUser = currentUser;
        this.wordService = wordService;
    }


    @GetMapping()
    public String index(Model model) {
        model.addAttribute("isLogged", false);
        return "index";
    }

    @GetMapping("/home")
    public String home(Model model) {
        if (currentUser.getId() == null) {
            return "redirect:/";
        }
        model.addAttribute("isLogged", true);
        model.addAttribute("loggedUserUsername", currentUser.getUsername());

        List<WordExportDto> germanList = wordService.wordListByLanguage(LanguageEnum.GERMAN);
        List<WordExportDto> spanishList = wordService.wordListByLanguage(LanguageEnum.SPANISH);
        List<WordExportDto> frenchList = wordService.wordListByLanguage(LanguageEnum.FRENCH);
        List<WordExportDto> italianList = wordService.wordListByLanguage(LanguageEnum.ITALIAN);

        model.addAttribute("germanList", germanList);
        model.addAttribute("spanishList", spanishList);
        model.addAttribute("frenchList", frenchList);
        model.addAttribute("italianList", italianList);

        int germanWordsCount = germanList.size();
        int spanishWordsCount = spanishList.size();
        int frenchWordsCount = frenchList.size();
        int italianWordsCount = italianList.size();

        int totalWords = germanWordsCount + spanishWordsCount + frenchWordsCount + italianWordsCount;

        model.addAttribute("germanWordsCount", germanWordsCount);
        model.addAttribute("spanishWordsCount", spanishWordsCount);
        model.addAttribute("frenchWordsCount", frenchWordsCount);
        model.addAttribute("italianWordsCount", italianWordsCount);
        model.addAttribute("totalWords", totalWords);

        return "home";
    }


}
