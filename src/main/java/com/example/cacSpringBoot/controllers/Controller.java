package com.example.cacSpringBoot.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/saludar")
public class Controller {

    @GetMapping("/sayHello")
    public String sayHello(){
        return "Hello!!";
    }

    @GetMapping("/sayGoodbye")
    public String sayGoodbyeToName (@RequestParam String nombre){ // Este es por query string
        return  "Adios " + nombre;
    }

    @GetMapping("/{name}")
    public String sayHelloToName(@PathVariable String name){ // Este es variable por ruta
        return "Hello " + name;
    }
}
