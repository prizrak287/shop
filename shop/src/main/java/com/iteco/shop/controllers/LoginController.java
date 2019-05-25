package com.iteco.shop.controllers;


import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/login")
public class LoginController {
    @GetMapping
    public String getLogin(@RequestParam(value = "error", required = false) String error, Authentication authentication, Model model) {
        if (authentication != null) {
            return "redirect:/";
        }
        if (error != null) {
            model.addAttribute("error", true);
        }
        return "login";
    }
}
