package com.iteco.shop.repo;

import com.iteco.shop.entities.Book;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BooksRepo extends JpaRepository<Book, Integer> {
    @EntityGraph(value = "bookGraph", type = EntityGraph.EntityGraphType.LOAD)
    List<Book> findByName(String name);
}
