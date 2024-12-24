package com.example.cacSpringBoot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewsController {

    @GetMapping()
    public String home(Model model) {
        model.addAttribute("message", "¡Bienvenido a mi app en Spring Boot!");
        return "home"; // Este es el nombre de la vista (home.html)
    }
}
