package com.likebookapp.controller;

import com.likebookapp.model.dto.PostExportDto;
import com.likebookapp.model.entity.Post;
import com.likebookapp.model.sec.CurrentUser;
import com.likebookapp.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {
    private final PostService postService;

    private final CurrentUser currentUser;

    public HomeController(PostService postService, CurrentUser currentUser) {
        this.postService = postService;
        this.currentUser = currentUser;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("isLogged", false);


        return "index";
    }

    @GetMapping("/home")
    public String home(Model model) {

        List<PostExportDto> myPosts = postService.getMyPosts();
        List<PostExportDto> otherPosts = postService.getPostDtoS();
        otherPosts.removeAll(myPosts);


        model.addAttribute("isLogged", true);
        model.addAttribute("myPosts", myPosts);
        model.addAttribute("otherPosts", otherPosts);
        model.addAttribute("username", currentUser.getUsername());
        model.addAttribute("total", otherPosts.size());

        return "home";
    }


}
