package com.tugceozcakir.example.controller;

import com.tugceozcakir.example.database.entity.PersonEntity;
import com.tugceozcakir.example.mapper.PersonMapper;
import com.tugceozcakir.example.model.PersonDTO;
import com.tugceozcakir.example.service.PersonService;
import com.tugceozcakir.example.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("person")
public class PersonController extends BaseController<PersonDTO,PersonEntity> {

    @Autowired
    PersonService personService;

    @Autowired
    PersonMapper personMapper;


    @Override
    public ResponseEntity<List<PersonDTO>> getAll() {
        List<PersonEntity> personEntityList = personService.getAllPersons();
        List<PersonDTO> personDTOList = personMapper.entityListToDTOList(personEntityList);
        return new ResponseEntity<>(personDTOList, HttpStatus.OK);
    }


    @Override
    public ResponseEntity<PersonEntity> getById(UUID id) {
        PersonEntity personEntity = personService.getPersonByUUID(id);
        if (personEntity != null) {
            return new ResponseEntity<>(personEntity, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    @Override
    public ResponseEntity<PersonEntity> create(@RequestBody PersonDTO personDTO) {
        try {
            PersonEntity personEntity = personService.createPerson(
                    personDTO.getName(), personDTO.getSurname(), personDTO.getTc(), personDTO.getBirthYear());
            return new ResponseEntity<>(personEntity, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<PersonEntity> update(UUID id, PersonEntity personEntity) {
        PersonEntity person = personService.updatePersonByUUID(id, personEntity);
        if (person != null) {
            return new ResponseEntity<>(person, HttpStatus.OK);

        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<Boolean> delete(UUID id) {
        Boolean isDeleted = personService.deletePersonByUUID(id);
        if (isDeleted) {
            return new ResponseEntity<>(Boolean.TRUE, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(Boolean.FALSE, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("person-list-by-name-start-with/{key}")
    public ResponseEntity<List<PersonEntity>> getPersonListByNameStartWith(@PathVariable String key) {
        return new ResponseEntity<>(personService.getPersonNameStartWith(key), HttpStatus.OK);
    }


    @GetMapping("person-list-by-name-i-contains/{key}")
    public ResponseEntity<List<PersonEntity>> getPersonListByNameICOntains(@PathVariable String key) {
        return new ResponseEntity<>(personService.getPersonNameIContains(key), HttpStatus.OK);
    }


    @GetMapping("person-list-by-name-surname-start-with/name/{name}/surname/{surname}")
    public ResponseEntity<List<PersonEntity>> getPersonListByNameICOntains(
            @PathVariable String name, @PathVariable String surname) {
        return new ResponseEntity<>(
                personService.getPersonNameStartWithAndSurnameStartWith(name, surname), HttpStatus.OK);
    }
}
