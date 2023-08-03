package com.tugceozcakir.pokemondatabase.database.repository;

import com.tugceozcakir.pokemondatabase.database.entity.PokemonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PokemonRepository extends JpaRepository<PokemonEntity, Long> {
    List<PokemonEntity> findAllBy();
    List<PokemonEntity> findAllByName(String name);
}
