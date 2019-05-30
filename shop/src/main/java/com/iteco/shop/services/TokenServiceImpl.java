package com.iteco.shop.services;

import com.iteco.shop.entities.Token;
import com.iteco.shop.entities.User;
import com.iteco.shop.forms.LoginForm;
import com.iteco.shop.repo.TokenRepo;
import com.iteco.shop.repo.UserRepo;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TokenServiceImpl implements TokenService {
    private TokenRepo tokenRepo;
    private PasswordEncoder passwordEncoder;
    private UserRepo userRepo;

    public TokenServiceImpl(TokenRepo tokenRepo, PasswordEncoder passwordEncoder, UserRepo userRepo) {
        this.tokenRepo = tokenRepo;
        this.passwordEncoder = passwordEncoder;
        this.userRepo = userRepo;
    }

    @Override
    public Token login(LoginForm loginForm) {
        Optional<User> userCandidate = userRepo.findOneByLogin(loginForm.getLogin());
        if (userCandidate.isPresent()) {
            User user = userCandidate.get();
            if (passwordEncoder.matches(loginForm.getPassword(), user.getHashPassword())) {
                Token token = new Token();
                token.setUser(user);
                token.setValue(RandomStringUtils.random(10, true, true));
                tokenRepo.save(token);
                return token;
            }
        }
        throw new IllegalArgumentException("User not found");
    }
}
