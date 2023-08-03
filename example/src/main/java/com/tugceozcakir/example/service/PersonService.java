package com.tugceozcakir.example.service;

import com.tugceozcakir.example.database.entity.PersonEntity;
import com.tugceozcakir.example.database.repository.PersonEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

//Bean
@Service
public class PersonService {

    @Value("${gizem:25}")
    int value;

    @Autowired
    PersonEntityRepository personEntityRepository;
    public PersonEntity createPerson(String name, String surname, String tc, int birthYear){
        PersonEntity person = new PersonEntity();
        person.setTc(tc);
        person.setName(name);
        person.setSurname(surname);
        person.setBirthYear(birthYear);

        personEntityRepository.save(person);
        System.out.println(value);
        return person;
    }
    public List<PersonEntity> getPersonNameStartWith(String key) {
        return personEntityRepository.findAllByNameStartingWith(key);
    }
    public List<PersonEntity> getPersonNameIContains(String key) {
        return personEntityRepository.findAllByNameContainsIgnoreCase(key);
    }

    public List<PersonEntity> getPersonNameStartWithAndSurnameStartWith(String name, String surname) {
        return personEntityRepository.findAllByNameStartingWithOrSurnameStartingWith(name, surname);
    }
}