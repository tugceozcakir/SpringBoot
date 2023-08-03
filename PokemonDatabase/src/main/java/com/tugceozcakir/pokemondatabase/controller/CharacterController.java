package com.tugceozcakir.pokemondatabase.controller;

import com.tugceozcakir.pokemondatabase.database.entity.CharacterEntity;
import com.tugceozcakir.pokemondatabase.service.CharacterService;
import com.tugceozcakir.pokemondatabase.util.dbutil.BaseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/character")
public class CharacterController {

    @Autowired
    CharacterService characterService;

    @GetMapping("all-character")
    public ResponseEntity<List<CharacterEntity>> getCharacters() {
        return new ResponseEntity<>(characterService.returnCharacters(), HttpStatus.OK);
    }

    @GetMapping("{name}")
    public ResponseEntity<List<CharacterEntity>> getCharacter(@PathVariable String name) {
        return new ResponseEntity<>(characterService.returnCharactersByName(name), HttpStatus.OK);
    }

    @GetMapping("starting-with/{key}")
    public ResponseEntity<List<CharacterEntity>> getCharacterStartingWith(@PathVariable String key) {
        return new ResponseEntity<>(characterService.returnCharactersStartingWith(key), HttpStatus.OK);
    }

    @PostMapping("character")
    public ResponseEntity<CharacterEntity> createCharacter(@RequestBody CharacterEntity character) {
        CharacterEntity newChar = characterService.createCharacter(character.getName());
        return new ResponseEntity<>(newChar,HttpStatus.OK);
    }

}
