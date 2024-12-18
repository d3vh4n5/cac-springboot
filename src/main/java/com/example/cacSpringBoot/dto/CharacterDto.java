package com.example.cacSpringBoot.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CharacterDto {
    public int id;
    public String name;
    public int height;
    public int mass;
    public String gender;
    public String homeworld;
    public String species;
}
