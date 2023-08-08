package com.tugceozcakir.example.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

public abstract class BaseController<DTO, Entity> {

    @GetMapping("/all")
    public abstract ResponseEntity<List<DTO>> getAll();

    @GetMapping("getById/{id}")
    public abstract ResponseEntity<Entity> getById(@PathVariable UUID id);

    @PostMapping("/create")
    public abstract ResponseEntity<Entity> create(@RequestBody DTO dto);

    @PutMapping("/update/{id}")
    public abstract ResponseEntity<Entity> update(@PathVariable UUID id, @RequestBody Entity entity);

    @DeleteMapping("/delete/{id}")
    public abstract ResponseEntity<Boolean> delete(@PathVariable UUID id);

}
