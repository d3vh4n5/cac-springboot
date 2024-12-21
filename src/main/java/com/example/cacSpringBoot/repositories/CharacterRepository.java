package com.example.cacSpringBoot.repositories;

import com.example.cacSpringBoot.entities.SWCharacter;
import com.example.cacSpringBoot.repositories.interfaces.ICharacterRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
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

    @Override
    public List<SWCharacter> searchWithParams(String name, String gender, String homeworld, String species) {
        List<SWCharacter> coincidences = null;

        if (name != null) coincidences = listOfChars.stream().filter( swc ->
                swc.getName().toLowerCase().contains(name.toLowerCase())
        ).toList();
        else coincidences = listOfChars;

        if (gender != null) coincidences = coincidences.stream().filter(swc ->{
                    if (swc.getGender() != null)
                        return swc.getGender().equalsIgnoreCase(gender);
                    return false;
                }
        ).toList();

        if (homeworld != null) coincidences = coincidences.stream().filter(swc -> {
                    if (swc.getHomeworld() != null)
                        return swc.getHomeworld().toLowerCase().contains(homeworld.toLowerCase());
                    return false;
                }
        ).toList();

        if (species != null) coincidences = coincidences.stream().filter(swc ->{
                    if (swc.getSpecies() != null)
                        return swc.getSpecies().toLowerCase().contains(species.toLowerCase());
                    return false;
                }
        ).toList();

        return coincidences;
    }

    private void loadChars(){
//        ObjectMapper mapper = new ObjectMapper();
//        File jsonFile = null;
//        try {
//            jsonFile = ResourceUtils.getFile("classpath:starwars.json");
//            listOfChars = mapper.readValue(jsonFile, new TypeReference<List<SWCharacter>>() {});
//        } catch (Exception ex) {
//            System.out.println("No existe el archivo json" + ex.getMessage());
//        }

        ObjectMapper mapper = new ObjectMapper();
        String filePath = "starwars.json";

        try {
//            URL res = getClass().getClassLoader().getResource(filePath);
//            if (res == null) {
//                throw new FileNotFoundException(filePath+" not found in resources folder");
//            }
            // assert res != null;
            // File file = Paths.get(res.toURI()).toFile();
            // listOfChars = mapper.readValue(file, new TypeReference<List<SWCharacter>>() {});


            // Obtener el recurso como InputStream
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream(filePath);

            // Verificar si el recurso existe
            if (inputStream == null) {
                throw new FileNotFoundException(filePath + " not found in resources folder");
            }

            listOfChars = mapper.readValue(inputStream, new TypeReference<List<SWCharacter>>() {});
        } catch (FileNotFoundException e){
            System.out.println("File not found. " + e.getMessage());
//        } catch (URISyntaxException e) {
//            System.out.println("URI Syntax error. "+ e.getMessage());
        } catch (IOException e) {
            System.out.println("Error when loading characters list. " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error when loading " + filePath+". " + e.getMessage());
            System.out.println("Exception type: " + e.getClass().getName());
            e.printStackTrace();
        }
    }
}
