package com.iteco.shop.services;

import com.iteco.shop.entities.Author;
import com.iteco.shop.repo.AuthorRepo;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@Lazy
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepo authorRepo;

    public AuthorServiceImpl(final AuthorRepo authorRepo) {
        this.authorRepo = authorRepo;
    }

    public List<Author> findAllAuthors() {
        return authorRepo.findAll();
    }

    public List<Author> findFirst(Integer i) {
        return authorRepo.findFirst(i);
    }

    public List<Author> findAuthorsByName(String name) {
        return authorRepo.findByName(name);
    }

    public Author findAuthor(Integer id) {
        Optional<Author> authorOpt = authorRepo.findById(id);
        return authorOpt.orElse(new Author());
    }

    public void deleteAuthor(Author author) {
        authorRepo.delete(author);
    }

    public void saveAuthor(Author author) {
        authorRepo.save(author);
    }
}
