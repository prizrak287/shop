package com.iteco.shop.controllers;

import com.iteco.shop.entities.Author;
import com.iteco.shop.services.AuthorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Comparator;
import java.util.List;

@Controller
@RequestMapping("/")
public class MainController {
    private AuthorService authorService;

    public MainController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public String getIndex(Model model) {
        List<Author> authors = authorService.findFirst(5);
        authors.sort(Comparator.comparing(Author::getName));
        model.addAttribute("listAuthors", authors);
        return "index";
    }
}
