package com.dictionaryapp.controller;

import com.dictionaryapp.model.sec.CurrentUser;
import com.dictionaryapp.service.WordService;
import com.dictionaryapp.validation.WordBindingModel;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/words")
public class WordController {

    private final WordService wordService;
    private final CurrentUser currentUser;

    public WordController(WordService wordService, CurrentUser currentUser) {
        this.wordService = wordService;
        this.currentUser = currentUser;
    }


    @GetMapping("/addWord")
    public String addWord() {

        if (currentUser.getId() == null) {
            return "redirect:/";
        }
        return "word-add";
    }

    @ModelAttribute
    public WordBindingModel wordBindingModel() {
        return new WordBindingModel();
    }

    @PostMapping("/addWord")
    public String addWordConfirm(@Valid WordBindingModel wordBindingModel,
                                 BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("wordBindingModel", wordBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.wordBindingModel",bindingResult);

            return "redirect:addWord";
        }

        wordService.addWord(wordBindingModel);

        return "redirect:/home";

    }

    @GetMapping("/deleteWord/{id}")
    public String deleteWord(@PathVariable("id") Long id) {

        if (currentUser.getId() == null) {
            return  "redirect:/";
        }

        wordService.deleteWordById(id);
        return "redirect:/home";
    }

    @GetMapping("/deleteAll")
    public String deleteAll() {

        if (currentUser.getId() == null) {
            return  "redirect:/";
        }

        wordService.deleteAll();
        return "redirect:/home";
    }

}
