package com.tugceozcakir.pokemondatabase.controller;

import com.tugceozcakir.pokemondatabase.database.entity.PokemonEntity;
import com.tugceozcakir.pokemondatabase.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pokemon")
public class PokemonController {
    @Autowired
    PokemonService pokemonService;

    @GetMapping("all-pokemon")
    public ResponseEntity<List<PokemonEntity>> getPokemon() {
        return new ResponseEntity<>(pokemonService.findPokemons(), HttpStatus.OK);
    }

    @GetMapping("{name}")
    public ResponseEntity<List<PokemonEntity>> getPokemon(@PathVariable String name) {
        return new ResponseEntity<>(pokemonService.findPokemon(name), HttpStatus.OK);
    }

    @GetMapping("{name}-ben-seni-sectim")
    public ResponseEntity<List<PokemonEntity>> getChoosePokemon(@PathVariable String name) {
        return new ResponseEntity<>(pokemonService.findPokemon(name), HttpStatus.OK);
    }

    @PostMapping("add-pokemon")
    public ResponseEntity<PokemonEntity> createPokemon(@RequestBody PokemonEntity pokemon) {
        PokemonEntity newPokemon = pokemonService.createPokemon(pokemon.getName());
        return new ResponseEntity<>(newPokemon, HttpStatus.OK);
    }
}
