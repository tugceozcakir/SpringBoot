package com.tugceozcakir.pokemondatabase.database.repository;

import com.tugceozcakir.pokemondatabase.database.entity.CharacterEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CharacterRepository extends JpaRepository<CharacterEntity, Long> {
    List<CharacterEntity> findAllBy();
    List<CharacterEntity> findAllByName(String name);
    List<CharacterEntity> findAllByNameStartingWith(String key);
}
