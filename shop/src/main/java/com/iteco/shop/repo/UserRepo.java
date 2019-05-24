package com.iteco.shop.repo;

import com.iteco.shop.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
    List<User> findByFirstName(String name);

    Optional<User> findOneByLogin(String login);
}
