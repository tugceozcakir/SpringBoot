package com.tugceozcakir.healthtourismproject.database.repository;

import com.tugceozcakir.healthtourismproject.database.entity.AdminEntity;
import com.tugceozcakir.healthtourismproject.database.entity.UserEntity;
import com.tugceozcakir.healthtourismproject.util.dbUtil.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends BaseRepository<UserEntity> {
    Optional<UserEntity> findByEmail(String email);
}
