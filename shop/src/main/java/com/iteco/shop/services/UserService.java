package com.iteco.shop.services;

import com.iteco.shop.entities.User;

import java.util.List;

public interface UserService {
    List<User> findAllUsers();
    List<User> findUserByName(String name);
    User findUser(Integer id);
    void saveUser(User user);
    void deleteUser(User user);
}
