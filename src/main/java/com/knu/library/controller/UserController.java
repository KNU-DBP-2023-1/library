package com.knu.library.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/")
    String home() {
        return "/home";
    }

    @GetMapping("/signup")
    String signup(Model model) {
        return "/user/signup";
    }

    @GetMapping("/login")
    String login(Model model) {
        return "/user/login";
    }
}
