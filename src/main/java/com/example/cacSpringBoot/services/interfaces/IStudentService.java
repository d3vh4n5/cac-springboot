package com.example.cacSpringBoot.services.interfaces;

import com.example.cacSpringBoot.dto.StudentDto;

import java.util.List;

public interface IStudentService {
    List<StudentDto> findAll();

    StudentDto create(StudentDto studentDto);
}
