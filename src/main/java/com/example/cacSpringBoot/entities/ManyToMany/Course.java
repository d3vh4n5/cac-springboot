package com.example.cacSpringBoot.entities.ManyToMany;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(mappedBy = "linkedCourses")
    private Set<StudentManyToMany> students;

}
