package com.example.salesproject.util;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;
import java.util.UUID;

@NoRepositoryBean
public interface BaseRepository<Entity> extends JpaRepository<Entity, Long>, JpaSpecificationExecutor<Entity> {
    Entity findByUuid(UUID uuid);
}
