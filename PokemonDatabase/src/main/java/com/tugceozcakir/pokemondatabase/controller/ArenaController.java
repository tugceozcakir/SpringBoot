package com.tugceozcakir.pokemondatabase.controller;

import com.tugceozcakir.pokemondatabase.database.entity.ArenaEntity;
import com.tugceozcakir.pokemondatabase.service.ArenaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/arena")
public class ArenaController {

    @Autowired
    ArenaService arenaService;

    @PostMapping("/add")
    public ResponseEntity<ArenaEntity> createArena(@RequestBody ArenaEntity arena) {
        ArenaEntity newArena = arenaService.createArena(arena.getName());
        return new ResponseEntity<>(newArena,HttpStatus.OK);
    }

    @GetMapping("all-arena")
    public ResponseEntity<List<ArenaEntity>> getArena() {
        return new ResponseEntity<>(arenaService.findArena(), HttpStatus.OK);
    }
}