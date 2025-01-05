package com.example.cacSpringBoot.repositories.interfaces;

import com.example.cacSpringBoot.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStudentRepository extends JpaRepository<Student, Long> {
    Student findByName(String name);
    // El metood save crea una entidad si no existe, y si existe la actualiza,
    // la diferencia es que oara que cree no le mandamos id, pero paraque actualice si
}

//
//https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repositories.query-methods.query-creation
//
//https://docs.spring.io/spring-data/jpa/docs/current/reference/html/
