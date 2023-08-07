package com.tugceozcakir.example.database.repository;

import com.tugceozcakir.example.database.entity.AddressEntity;
import com.tugceozcakir.example.util.BaseRepository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

@Repository
public interface AddressEntityRepository extends BaseRepository<AddressEntity> {
    Optional<AddressEntity> findByUuid(UUID uuid);
}
