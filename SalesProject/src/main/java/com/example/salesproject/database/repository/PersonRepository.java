package com.example.salesproject.database.repository;

import com.example.salesproject.database.entity.PersonEntity;
import com.example.salesproject.util.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends BaseRepository<PersonEntity> {
    List<PersonEntity> findAllByNameStartingWith(String key);

    List<PersonEntity> findAllByNameContainsIgnoreCase(String key);

    List<PersonEntity> findAllByNameStartingWithOrSurnameStartingWith(String name, String surname);
}
