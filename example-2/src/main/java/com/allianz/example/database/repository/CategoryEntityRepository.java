package com.allianz.example.database.repository;

import com.allianz.example.database.entity.BillEntity;
import com.allianz.example.database.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CategoryEntityRepository extends JpaRepository<CategoryEntity, Long> {
    Optional<CategoryEntity> findByUuid(UUID uuid);
}
