package com.iteco.shop.controllers;


import com.iteco.shop.entities.Token;
import com.iteco.shop.forms.LoginForm;
import com.iteco.shop.services.TokenService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {
    private TokenService service;

    public LoginController(TokenService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Token> logIn(@RequestBody LoginForm loginForm) {
       return ResponseEntity.ok(service.login(loginForm));
   }
}
