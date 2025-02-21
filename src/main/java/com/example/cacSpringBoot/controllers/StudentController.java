package com.example.cacSpringBoot.controllers;

import com.example.cacSpringBoot.dto.StudentDto;
import com.example.cacSpringBoot.services.StudentService;
import com.example.cacSpringBoot.services.interfaces.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    IStudentService studentService;
    public StudentController (StudentService studentService){
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseEntity<?> findAll(){
        return new ResponseEntity<>(
                studentService.findAll(), HttpStatus.OK
        );
    }

    @PostMapping
    public ResponseEntity<?> createStudent(@RequestBody StudentDto studentDto){
        return new ResponseEntity<>(
                studentService.create(studentDto),
                HttpStatus.CREATED
        );
    }
}
