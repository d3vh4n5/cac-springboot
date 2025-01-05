package com.example.cacSpringBoot.dto;

import lombok.*;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode // Sobreescribo el equals para comprar los atributos y no el espacio en memoria
public class StudentDto {
    private String dni;
    private String name;
    private String lastname;
}
