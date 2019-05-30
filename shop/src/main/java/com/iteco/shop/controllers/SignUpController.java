package com.iteco.shop.controllers;

import com.iteco.shop.entities.User;
import com.iteco.shop.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/signUp")
public class SignUpController {
    private final UserService service;

    public SignUpController(UserService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Object> signUp(@RequestBody User user) {
     service.saveUser(user);
     return ResponseEntity.ok().build();
    }
}
