package com.tugceozcakir.erpsystem.database.repository;

import com.tugceozcakir.erpsystem.database.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {
    void deleteByUuid(UUID uuid);
    CustomerEntity findByUuid(UUID uuid);
    List<CustomerEntity> findAllByNameContainsIgnoreCase(String name);
}
