package com.iteco.shop.repo;

import com.iteco.shop.entities.Token;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TokenRepo extends JpaRepository<Token, Integer> {
    Optional<Token> findOneByValue(String value);
}
