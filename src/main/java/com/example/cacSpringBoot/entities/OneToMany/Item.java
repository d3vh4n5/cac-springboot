package com.example.cacSpringBoot.entities.OneToMany;

import jakarta.persistence.*;

@Entity
@Table(name="items")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="cart_id", nullable = false)
    private Cart cart;
}
