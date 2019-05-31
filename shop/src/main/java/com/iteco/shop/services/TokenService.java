package com.iteco.shop.services;

import com.iteco.shop.entities.Token;
import com.iteco.shop.forms.LoginForm;

public interface TokenService {
    Token login(LoginForm loginForm);
    Token findOneByValue(String value);
}
