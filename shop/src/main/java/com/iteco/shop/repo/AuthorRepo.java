package com.iteco.shop.repo;

import com.iteco.shop.entities.Author;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepo extends JpaRepository<Author, Integer> {
    @EntityGraph(value = "authorGraph", type = EntityGraph.EntityGraphType.LOAD)
    List<Author> findByName(String name);

    @Query(value = "select * from authors limit :count", nativeQuery = true)
    List<Author> findFirst(@Param("count") Integer limit);
}
