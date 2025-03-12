package com.project.seasky.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {
    @GetMapping("/")
    public String showLogin() {
        return "login";
    }

    @GetMapping("/register")
    public String showRegister() {
        return "register";
    }

    @GetMapping("/home")
    public String showHome() {
        return "index";
    }

    @GetMapping("/bookings")
    public String showBookings() {
        return "bookings";
    }

    @GetMapping("/error")
    public String showError() {
        return "error";
    }
}