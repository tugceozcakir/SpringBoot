package com.tugceozcakir.customerregistationapp.database.repository;

import com.tugceozcakir.customerregistationapp.database.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {
    Optional<CustomerEntity> findById(Long id);

}
