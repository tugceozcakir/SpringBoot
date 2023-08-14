package com.example.salesproject.util;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface BaseRepository<Entity> extends JpaRepository<Entity, Long> {
    Optional<Entity> findByUuid(UUID uuid);
}
