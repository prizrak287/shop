package com.iteco.shop.services;

import com.iteco.shop.entities.Book;

import java.util.List;

public interface BookService {
    List<Book> findAllBooks();
    Book findBook(Integer id);
    List<Book> findBookByName(String name);
    void saveBook(Book book);
    void deleteBook(Book book);
}
