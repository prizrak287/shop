package com.iteco.shop.repo;

import com.iteco.shop.entities.Token;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenRepo extends JpaRepository<Token, Integer> {
}
