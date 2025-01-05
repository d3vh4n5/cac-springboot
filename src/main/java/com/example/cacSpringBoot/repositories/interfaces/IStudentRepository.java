package com.example.cacSpringBoot.repositories.interfaces;

import com.example.cacSpringBoot.dto.StudentDto;
import com.example.cacSpringBoot.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IStudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByName(String name);
    // El metood save crea una entidad si no existe, y si existe la actualiza,
    // la diferencia es que oara que cree no le mandamos id, pero paraque actualice si
}

//
//https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repositories.query-methods.query-creation
//
//https://docs.spring.io/spring-data/jpa/docs/current/reference/html/
