package com.iteco.shop.services;

import com.iteco.shop.entities.Author;

import java.util.List;

public interface AuthorService {
    List<Author> findAllAuthors();
    List<Author> findAuthorsByName(String name);
    List<Author> findFirst(Integer count);
    Author findAuthor(Integer id);
    void saveAuthor(Author author);
    void deleteAuthor(Author author);
}
