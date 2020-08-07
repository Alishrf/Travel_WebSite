package io.github.alishrf.travel_website.controller;


import io.github.alishrf.travel_website.model.User;

import io.github.alishrf.travel_website.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    DaoAuthenticationProvider daoAuthenticationProvider;


    @GetMapping("/login")
    public String login() {
        return "security/login.html";
    }


    @PostMapping("/login")
    public String authenticate(@RequestParam(name = "uname") String username,
                               @RequestParam(required = true, name = "psw") String password) {
        Authentication auth = new UsernamePasswordAuthenticationToken(username, password);
        Authentication authenticated = daoAuthenticationProvider.authenticate(auth);
        SecurityContextHolder.getContext().setAuthentication(authenticated);
        return "index.html";

    }

    @GetMapping("/logout")
    public String logout() {
        SecurityContextHolder.clearContext();
        return "index.html";
    }

    @GetMapping("/register")
    public String register() {
        return "security/register.html";
    }


    @PostMapping("/register")
    public String register(@RequestParam(name = "uname") String username,
                           @RequestParam(name = "psw") String password) {
        User user = new User();
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        user.setUsername(username);
        user.setPassword(bCryptPasswordEncoder.encode(password));
        userService.save(user);
        return "/login";

    }
}
