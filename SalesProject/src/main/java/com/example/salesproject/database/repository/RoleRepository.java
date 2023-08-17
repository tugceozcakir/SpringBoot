package com.example.salesproject.database.repository;

import com.example.salesproject.database.entity.RoleEntity;
import com.example.salesproject.util.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends BaseRepository<RoleEntity> {
    Optional<RoleEntity> findByName(String name);

}
