package com.tugceozcakir.erpsystem.database.repository;

import com.tugceozcakir.erpsystem.database.entity.InvoiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface InvoiceRepository extends JpaRepository<InvoiceEntity, Long> {
    InvoiceEntity findByUuid(UUID uuid);
    void deleteByUuid(UUID uuid);
}
