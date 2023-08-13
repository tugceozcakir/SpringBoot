package com.tugceozcakir.questapp.database.repository;

import com.tugceozcakir.questapp.database.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
