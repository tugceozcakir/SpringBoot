package com.allianz.example.database.repository;

import com.allianz.example.database.entity.BillEntity;
import com.allianz.example.database.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface OrderEntityRepository extends JpaRepository<OrderEntity, Long> {
    Optional<OrderEntity> findByUuid(UUID uuid);
}