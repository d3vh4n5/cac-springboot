package com.example.cacSpringBoot.services;

import com.example.cacSpringBoot.dto.StudentDto;
import com.example.cacSpringBoot.entities.Student;
import com.example.cacSpringBoot.repositories.interfaces.IStudentRepository;
import com.example.cacSpringBoot.services.interfaces.IStudentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements IStudentService {

    private IStudentRepository studentRepository;
    public StudentService(IStudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    public List<StudentDto> findAll (){
        List<Student> students = studentRepository.findAll();
        System.out.println(studentRepository.findByName("juan"));
        ObjectMapper mapper = new ObjectMapper();
        List<StudentDto> lista = students.stream().map(student -> {
            return new StudentDto(student.getDni(), student.getName(), student.getLastname());
        }).toList();

        return lista;
    }

    @Override
    public StudentDto create(StudentDto studentDto) {
        studentRepository.save(new Student(
                null,
                studentDto.getDni(),
                studentDto.getName(),
                studentDto.getLastname()
        ));
        return studentDto;
    }

}
