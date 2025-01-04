package com.example.cacSpringBoot.repositories.interfaces;

import com.example.cacSpringBoot.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStudentRepository extends JpaRepository<Student, Long> {

}
