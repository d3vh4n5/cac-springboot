package com.example.cacSpringBoot.services.interfaces;


import com.example.cacSpringBoot.dto.CharacterDto;
import com.example.cacSpringBoot.dto.request.ReqNameDto;

import java.util.List;

public interface ICharacterService {
    List<CharacterDto> findAllCharacters();
    List<CharacterDto> findCharactersByName (ReqNameDto reqNameDto);
    List<CharacterDto> searchWithFilters(String name, String gender, String homeworld, String species);
}
