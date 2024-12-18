package com.example.cacSpringBoot.repositories.interfaces;

import com.example.cacSpringBoot.entities.SWCharacter;

import java.util.List;

public interface ICharacterRepository {
    List<SWCharacter> findAll();
    List<SWCharacter> findCharactersByName(String name);
}
