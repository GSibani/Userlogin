package com.example.logindemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

	@GetMapping("/login")
    public String loginPage() {
        return "login";  // This should be your login HTML page
    }

    @GetMapping("/hello")
    public String helloPage() {
        return "hello";  // This should be the hello page after successful login
    }
}
