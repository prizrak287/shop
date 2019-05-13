package com.iteco.shop.controllers;

import com.iteco.shop.entities.Author;
import com.iteco.shop.services.AuthorServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;

@Controller
@RequestMapping("/authors")
public class AuthorsController {

    private final AuthorServiceImpl authorService;

    public AuthorsController(AuthorServiceImpl authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public String getAuthors(Model model) {
        List<Author> authors = authorService.findAllAuthors();
        authors.sort(Comparator.comparing(Author::getName));
        model.addAttribute("listAuthors", authors);
        return "authors";
    }

    @GetMapping("/info")
    public String getAuthor(@RequestParam("id") Integer id, Model model) {
        Author author = authorService.findAuthor(id);
        model.addAttribute("authorInfo", author);
        return "authorInfo";
    }

    @GetMapping("/search")
    public String getAuthors(@RequestParam("author_name") String name, Model model) {
        List<Author> authors = authorService.findAuthorsByName(name);
        authors.sort(Comparator.comparing(Author::getName));
        model.addAttribute("listAuthors", authors);
        return "authors";
    }

    @PostMapping("/delete")
    public @ResponseBody
    boolean deleteAuthor(@RequestParam("id") Integer id, Model model) {
        try {
            Author author = authorService.findAuthor(id);
            authorService.deleteAuthor(author);
            return true;
        }
        catch (Exception ex) {
            return false;
        }
    }

    @PostMapping("/add")
    public @ResponseBody
    String addAuthor(@RequestBody Author author, Model model) {
        authorService.saveAuthor(author);
        model.addAttribute("authorName", author.getName());
        return "Author " + author.getName() + " successfully added";
    }
}
