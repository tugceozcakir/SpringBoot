package com.tugceozcakir.pokemondatabase.service;

import com.tugceozcakir.pokemondatabase.database.entity.ArenaEntity;
import com.tugceozcakir.pokemondatabase.database.entity.CharacterEntity;
import com.tugceozcakir.pokemondatabase.database.repository.ArenaRepository;
import com.tugceozcakir.pokemondatabase.database.repository.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArenaService {

    @Autowired
    ArenaRepository arenaEntityRepository;

    public ArenaEntity createArena(String name) {
        ArenaEntity arena = new ArenaEntity();
        arena.setName(name);
        arenaEntityRepository.save(arena);
        return arena;
    }

    public List<ArenaEntity> findArena() {
        return arenaEntityRepository.findAllBy();
    }
}
