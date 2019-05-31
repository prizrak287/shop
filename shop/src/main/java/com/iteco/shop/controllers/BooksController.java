package com.iteco.shop.controllers;

import com.iteco.shop.entities.Book;
import com.iteco.shop.services.BookServiceImpl;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BooksController {

    private BookServiceImpl bookService;

    public BooksController(BookServiceImpl bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> getBooks() {
        List<Book> books = bookService.findAllBooks();
        books.sort(Comparator.comparing(Book::getName));
        return books;
    }

    @GetMapping("/info")
    public String getBookInfo(@RequestParam("id") int id, Model model) {
        Book book = bookService.findBook(id);
        model.addAttribute("bookInfo", book);
        return "bookInfo";
    }

    @GetMapping("/search")
    public String getBooks(@RequestParam("book_name") String name, Model model) {
        List<Book> books = bookService.findBookByName(name);
        books.sort(Comparator.comparing(Book::getName));
        model.addAttribute("listBooks", books);
        return "books";
    }

    @PostMapping("/delete")
    public String deleteBook(@RequestParam("id") Integer id, Model model) {
        Book book = bookService.findBook(id);
        bookService.deleteBook(book);
        model.addAttribute("deleted", book.getName());
        model.addAttribute("entity", "Book");
        return "deleted";
    }
}
