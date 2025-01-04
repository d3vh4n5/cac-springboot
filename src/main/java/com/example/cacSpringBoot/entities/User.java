package com.example.cacSpringBoot.entities;

import com.example.cacSpringBoot.constants.ValidationConstraints;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Entity
//@Table(name="usuarios") // Ledigo que el nombre de la tabla en la db es usuarios
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name="id")
//    private int id;

//    @Column(nullable = false, length = ValidationConstraints.MAX_NAME_CHARS)
    private String name;
    private int edad;
}
