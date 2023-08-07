package com.tugceozcakir.example.database.repository;

import com.tugceozcakir.example.database.entity.PersonEntity;
import com.tugceozcakir.example.util.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface PersonEntityRepository extends BaseRepository<PersonEntity> {
    List<PersonEntity> findAllByNameStartingWith(String key);
    List<PersonEntity> findAllByNameContainsIgnoreCase(String key);
    List<PersonEntity> findAllByNameStartingWithOrSurnameStartingWith(String name, String surname);
    List<PersonEntity> getPersonAllByName(String name);
    void deletePersonByName(String name);
    Optional<PersonEntity> findByUuid(UUID uuid);
    void deletePersonByUuid(UUID uuid);
    long deleteByUuid(UUID uuid);
}

