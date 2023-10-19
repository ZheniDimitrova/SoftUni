package com.likebookapp.controller;

import com.likebookapp.model.binding.PostBindingModel;
import com.likebookapp.model.sec.CurrentUser;
import com.likebookapp.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("posts")
public class PostController {

    private final PostService postService;
    private final CurrentUser currentUser;

    public PostController(PostService postService, CurrentUser currentUser) {
        this.postService = postService;
        this.currentUser = currentUser;
    }


    @GetMapping("/addPost")
    public String addPost() {

        return "post-add";
    }


    @ModelAttribute
    public PostBindingModel postBindingModel() {
        return new PostBindingModel();
    }

    @PostMapping("/addPost")
    public String addPostConfirm(@Valid PostBindingModel postBindingModel, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("postBindingModel", postBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.postBindingModel", bindingResult);

            return "redirect:addPost";
        }

        postService.addPost(postBindingModel);


        return "redirect:/home";
    }

    @GetMapping("/remove/{id}")
    public String removePost(@PathVariable("id") Long id) {
        postService.deletePost(id);
        return "redirect:/home";
    }

    @GetMapping("/likeButton/{id}")
    public String likeButton(@PathVariable("id") Long id) {
        postService.likePost(id, currentUser.getUsername());

        return "redirect:/home";
    }


}
