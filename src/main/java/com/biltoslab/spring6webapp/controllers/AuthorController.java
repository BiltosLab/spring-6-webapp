package com.biltoslab.spring6webapp.controllers;


import com.biltoslab.spring6webapp.services.AuthorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }


    @RequestMapping("/authors")
    public String GetAuthors(Model model) {

        model.addAttribute("authors",authorService.FindAll());
        return "authors";
    }

}
