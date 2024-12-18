package com.example.cacSpringBoot.controllers;

import com.example.cacSpringBoot.dto.UserDto;
import com.example.cacSpringBoot.dto.response.SuccessfullyResponseDto;
import com.example.cacSpringBoot.services.IUserService;
import com.example.cacSpringBoot.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    IUserService userService;
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers(){
        return new ResponseEntity<>(userService.listUsers(), HttpStatus.OK);
    }

//    @GetMapping("/create/{name}")
//    public User createUser(@PathVariable String name){
//        return new User(name, 33);
//    }

    @PostMapping("/create")
    // @ResponseBody
    public ResponseEntity<SuccessfullyResponseDto> createUser(@RequestBody UserDto userDto){
        return new ResponseEntity<>(userService.createUser(userDto), HttpStatus.CREATED);
    }

    @PutMapping("/update/{name}")
    public ResponseEntity<SuccessfullyResponseDto> updateUser(
            @PathVariable String name,
            @RequestBody UserDto userDto){
        return new ResponseEntity<>(userService.updateUser(name, userDto), HttpStatus.OK);
    }

}
