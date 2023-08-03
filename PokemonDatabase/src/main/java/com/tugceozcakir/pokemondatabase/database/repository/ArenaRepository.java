package com.tugceozcakir.pokemondatabase.database.repository;

import com.tugceozcakir.pokemondatabase.database.entity.ArenaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArenaRepository extends JpaRepository<ArenaEntity, Long> {
    List<ArenaEntity> findAllBy();
}
