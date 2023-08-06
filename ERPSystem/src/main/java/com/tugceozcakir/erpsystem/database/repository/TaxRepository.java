package com.tugceozcakir.erpsystem.database.repository;

import com.tugceozcakir.erpsystem.database.entity.TaxEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TaxRepository extends JpaRepository<TaxEntity, Long> {
    TaxEntity findByUuid(UUID uuid);
    List<TaxEntity> findAllByNameContainsIgnoreCase(String name);
    void deleteByUuid(UUID uuid);

}
