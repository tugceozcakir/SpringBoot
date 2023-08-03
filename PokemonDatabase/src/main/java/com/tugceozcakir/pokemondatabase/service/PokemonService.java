package com.tugceozcakir.pokemondatabase.service;

import com.tugceozcakir.pokemondatabase.database.entity.PokemonEntity;
import com.tugceozcakir.pokemondatabase.database.repository.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PokemonService {
    @Autowired
    private PokemonRepository pokemonRepository;

    public PokemonEntity createPokemon(String name) {
        PokemonEntity pokemon = new PokemonEntity();
        pokemon.setName(name);
        pokemonRepository.save(pokemon);
        return pokemon;
    }

    public List<PokemonEntity> findPokemons() {
        return pokemonRepository.findAllBy();
    }
    public List<PokemonEntity> findPokemon(String name) {
        return pokemonRepository.findAllByName(name);
    }
}
