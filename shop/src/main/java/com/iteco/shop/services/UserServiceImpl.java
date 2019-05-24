package com.iteco.shop.services;

import com.iteco.shop.entities.User;
import com.iteco.shop.repo.UserRepo;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepo userRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<User> findAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public List<User> findUserByName(String name) {
        return userRepo.findByFirstName(name);
    }

    @Override
    public User findUser(Integer id) {
        Optional<User> authorOpt = userRepo.findById(id);
        return authorOpt.orElse(new User());
    }

    @Override
    public void deleteUser(User user) {
        userRepo.delete(user);
    }

    @Override
    public void saveUser(User user) {
        user.setHashPassword(passwordEncoder.encode(user.getHashPassword()));
        userRepo.save(user);
    }
}
