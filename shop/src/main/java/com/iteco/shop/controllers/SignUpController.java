package com.iteco.shop.controllers;

import com.iteco.shop.entities.User;
import com.iteco.shop.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/signUp")
public class SignUpController {
    private final UserService service;

    public SignUpController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public String getSignUpPage() {
        return "signUp";
    }

    @PostMapping
    public String signUp(User user) {
     service.saveUser(user);
     return "redirect:/login";
    }
}
