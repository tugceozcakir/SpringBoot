package com.example.salesproject.database.repository;

import com.example.salesproject.database.entity.UserEntity;
import com.example.salesproject.util.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends BaseRepository<UserEntity> {

    Optional<UserEntity> findByEmail(String email);
}
