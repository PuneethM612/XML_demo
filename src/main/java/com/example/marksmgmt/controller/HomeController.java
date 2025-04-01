package com.example.marksmgmt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controller for the home page
 */
public class HomeController {
    
    @GetMapping("/")
    public String home() {
        return "index";
    }
} 