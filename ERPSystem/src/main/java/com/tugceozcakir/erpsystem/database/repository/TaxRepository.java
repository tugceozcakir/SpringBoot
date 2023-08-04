package com.tugceozcakir.erpsystem.database.repository;

import com.tugceozcakir.erpsystem.database.entity.TaxEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaxRepository extends JpaRepository<TaxEntity, Long> {
}
