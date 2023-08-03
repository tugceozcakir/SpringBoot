package com.tugceozcakir.pokemondatabase.service;

import com.tugceozcakir.pokemondatabase.database.entity.CharacterEntity;
import com.tugceozcakir.pokemondatabase.database.repository.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CharacterService {

    @Autowired
    private CharacterRepository characterRepository;

    @Autowired
    PokemonService pokemonService;

    public CharacterEntity createCharacter(String name) {
        CharacterEntity character = new CharacterEntity();
        character.setName(name);
        characterRepository.save(character);
        return character;
    }

    public List<CharacterEntity> returnCharacters() {
        return characterRepository.findAllBy();
    }

    public List<CharacterEntity> returnCharactersByName(String name) {
        return characterRepository.findAllByName(name);
    }

    public List<CharacterEntity> returnCharactersStartingWith(String key) {
        return characterRepository.findAllByNameStartingWith(key);
    }
}
