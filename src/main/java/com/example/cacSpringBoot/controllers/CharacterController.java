package com.example.cacSpringBoot.controllers;

import com.example.cacSpringBoot.dto.request.ReqNameDto;
import com.example.cacSpringBoot.services.CharacterService;
import com.example.cacSpringBoot.services.interfaces.ICharacterService;
import jakarta.annotation.Nullable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/starwars")
public class CharacterController {

    ICharacterService characterService;
    public CharacterController(CharacterService characterService){
        this.characterService = characterService;
    }

    @GetMapping("/characters")
    public ResponseEntity<?> getAllCharacters(){
        return new ResponseEntity<>(characterService.findAllCharacters(), HttpStatus.OK);
    }

    @GetMapping("/characters/search")
    public ResponseEntity<?> searchCharacter(
            @Nullable @RequestParam String name
    ){
        return null;
    }

    @GetMapping("/characters/{name}")
    public ResponseEntity<?> getCharacterByName(@PathVariable String name){
        ReqNameDto reqNameDto = new ReqNameDto(name);
        return new ResponseEntity<>(characterService.findCharactersByName(reqNameDto), HttpStatus.OK);
    }
}
