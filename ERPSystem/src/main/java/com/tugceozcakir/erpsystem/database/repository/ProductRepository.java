package com.tugceozcakir.erpsystem.database.repository;

import com.tugceozcakir.erpsystem.database.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
    ProductEntity findByUuid(UUID uuid);
    void deleteByUuid(UUID uuid);
    List<ProductEntity> findAllByNameContainsIgnoreCase(String name);


}