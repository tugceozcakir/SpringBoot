package com.tugceozcakir.questapp.database.repository;

import com.tugceozcakir.questapp.database.entity.LikeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository<LikeEntity, Long> {
}
