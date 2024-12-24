package com.example.cacSpringBoot.controllers;

import com.example.cacSpringBoot.dto.UserDto;
import com.example.cacSpringBoot.dto.request.ReqNameDto;
import com.example.cacSpringBoot.dto.response.SuccessfullyResponseDto;
import com.example.cacSpringBoot.services.interfaces.IUserService;
import com.example.cacSpringBoot.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.validation.beanvalidation.SpringValidatorAdapter;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

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

    @GetMapping("/{name}")
    public ResponseEntity<UserDto> getOneUser(@PathVariable String name){
        ReqNameDto reqNameDto = new ReqNameDto(name);
        return new ResponseEntity<>(userService.listOneUser(reqNameDto), HttpStatus.OK);
    }

//    @GetMapping("/create/{name}")
//    public User createUser(@PathVariable String name){
//        return new User(name, 33);
//    }


    @PostMapping("/create")
    public ResponseEntity<SuccessfullyResponseDto> createUser(@Valid @RequestBody UserDto userDto) {
        return new ResponseEntity<>(userService.createUser(userDto), HttpStatus.CREATED);
    }

    @PutMapping("/update/{name}")
    public ResponseEntity<SuccessfullyResponseDto> updateUser(
            @PathVariable String name,
            @RequestBody UserDto userDto){
        return new ResponseEntity<>(userService.updateUser(name, userDto), HttpStatus.OK);
    }
}
