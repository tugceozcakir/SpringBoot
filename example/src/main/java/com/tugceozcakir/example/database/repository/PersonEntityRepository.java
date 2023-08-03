package com.tugceozcakir.example.database.repository;

import com.tugceozcakir.example.database.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonEntityRepository extends JpaRepository<PersonEntity, Long> {
    List<PersonEntity> findAllByNameStartingWith(String key);

    List<PersonEntity> findAllByNameContainsIgnoreCase(String key);

    List<PersonEntity> findAllByNameStartingWithOrSurnameStartingWith(String name, String surname);

    //SQL Injection
    //"select * from User where username ="+username+" and password=" + password + "or 1=1"
    //ikisinden biri çalışır.
    @Query("select p from PersonEntity  p where p.name = ?1 and p.surname = ?2")
    List<PersonEntity> getPersonAllByName(String name, String surname);

    @Query("delete from PersonEntity p where p.name=?1")
    void deletePersonByName(String name);

























}
