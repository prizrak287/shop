package com.iteco.shop.services;

import com.iteco.shop.entities.Book;
import com.iteco.shop.repo.BooksRepo;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@Lazy
public class BookServiceImpl implements BookService{

    private BooksRepo booksRepo;

    public BookServiceImpl(BooksRepo booksRepo) {
        this.booksRepo = booksRepo;
    }

    @Override
    public List<Book> findAllBooks() {
        return booksRepo.findAll();
    }

    @Override
    public List<Book> findBookByName(String name) {
       return booksRepo.findByName(name);
    }

    @Override
    public Book findBook(Integer id) {
        Optional<Book> bookOpt = booksRepo.findById(id);
        return bookOpt.orElse(new Book());
    }

    @Override
    public void saveBook(Book book) {
        booksRepo.save(book);
    }

    @Override
    public void deleteBook(Book book) {
        booksRepo.delete(book);
    }
}
