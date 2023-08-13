package com.tugceozcakir.questapp.database.repository;

import com.tugceozcakir.questapp.database.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<PostEntity, Long> {
    List<PostEntity> findByUserId(Long userId);
    Optional<PostEntity> findById(Long postId);
}
