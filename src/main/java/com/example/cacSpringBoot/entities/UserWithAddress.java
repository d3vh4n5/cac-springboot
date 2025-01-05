package com.example.cacSpringBoot.entities;

import com.example.cacSpringBoot.constants.ValidationConstraints;
import jakarta.persistence.*;

@Entity
@Table
public class UserWithAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(nullable = false, length = ValidationConstraints.MAX_NAME_CHARS)
    private String name;
    private int edad;

//    @OneToOne(cascade = CascadeType.ALL)
    @OneToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE })
    @JoinColumn(name = "address_id", referencedColumnName = "id") // foreign key
    private Address address;
}
