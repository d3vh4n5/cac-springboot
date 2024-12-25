package com.example.cacSpringBoot.controllers;

import com.example.cacSpringBoot.dto.response.HelloDto;
import com.example.cacSpringBoot.services.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class SayHelloController {

    @Autowired
    IUserService userService;

    @GetMapping("/sayHello/{name}")
    public ResponseEntity<?> sayHello(@PathVariable String name){
        return new ResponseEntity<>(userService.saludar(name), HttpStatus.OK);
    }

    @GetMapping("/sayHello")
    public ResponseEntity<?> sayHello2(@RequestParam String name){
        return new ResponseEntity<>(userService.saludar(name), HttpStatus.OK);
    }

    @PostMapping("/crearSaludo")
    public ResponseEntity<?> sayHello3(@RequestBody HelloDto helloDto){
        helloDto.setSaludo(helloDto.getSaludo() + " agregado");
        return new ResponseEntity<>(helloDto, HttpStatus.OK);
    }
}
