package com.example.cacSpringBoot.services;

import com.example.cacSpringBoot.dto.CharacterDto;
import com.example.cacSpringBoot.dto.request.ReqNameDto;
import com.example.cacSpringBoot.entities.SWCharacter;
import com.example.cacSpringBoot.repositories.CharacterRepository;
import com.example.cacSpringBoot.repositories.interfaces.ICharacterRepository;
import com.example.cacSpringBoot.services.interfaces.ICharacterService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterService implements ICharacterService {

    ICharacterRepository characterRepository;
    public CharacterService (CharacterRepository characterRepository){
        this.characterRepository = characterRepository;
    }


    @Override
    public List<CharacterDto> findAllCharacters() {
        List<SWCharacter> characters = characterRepository.findAll();
        return characters.stream().map( ch ->
            new CharacterDto(
                    ch.getId(),
                    ch.getName(),
                    ch.getHeight(),
                    ch.getMass(),
                    ch.getGender(),
                    ch.getHomeworld(),
                    ch.getSpecies()
            )
        ).toList();
    }

    @Override
    public List<CharacterDto> findCharactersByName(ReqNameDto reqNameDto) {
        List<SWCharacter> charactersFound = characterRepository.findCharactersByName(reqNameDto.getName());
        return charactersFound.stream().map( ch ->
                new CharacterDto(
                        ch.getId(),
                        ch.getName(),
                        ch.getHeight(),
                        ch.getMass(),
                        ch.getGender(),
                        ch.getHomeworld(),
                        ch.getSpecies()
                )
        ).toList();
    }
}
