package com.allianz.example.database.repository;

import com.allianz.example.database.entity.BillEntity;
import com.allianz.example.database.entity.OrderItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface OrderItemRepository extends JpaRepository<OrderItemEntity, Long> {
    Optional<OrderItemEntity> findByUuid(UUID uuid);
}