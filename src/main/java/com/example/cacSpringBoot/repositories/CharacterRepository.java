package com.example.cacSpringBoot.repositories;

import com.example.cacSpringBoot.entities.SWCharacter;
import com.example.cacSpringBoot.repositories.interfaces.ICharacterRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CharacterRepository implements ICharacterRepository {

    private List<SWCharacter> listOfChars = new ArrayList<>();

    public CharacterRepository(){
        loadChars();
    }

    @Override
    public List<SWCharacter> findAll() {
        return listOfChars;
    }

    @Override
    public List<SWCharacter> findCharactersByName(String name) {
        return listOfChars.stream().filter(e -> e.getName().toLowerCase().contains(name.toLowerCase()) ).toList();
    }

    private void loadChars(){
        ObjectMapper mapper = new ObjectMapper();
        File jsonFile = null;
        try {
            jsonFile = ResourceUtils.getFile("classpath:starwars.json");
            listOfChars = mapper.readValue(jsonFile, new TypeReference<List<SWCharacter>>() {});
        } catch (Exception ex) {
            System.out.println("No existe el archivo json" + ex.getMessage());
        }
    }
}
