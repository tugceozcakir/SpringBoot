package com.example.salesproject.service;

import com.example.salesproject.database.entity.PersonEntity;
import com.example.salesproject.database.repository.PersonRepository;
import com.example.salesproject.database.specification.PersonSpecification;
import com.example.salesproject.mapper.PersonMapper;
import com.example.salesproject.model.PersonDTO;
import com.example.salesproject.model.requestDTO.PersonRequestDTO;
import com.example.salesproject.util.BaseRepository;
import com.example.salesproject.util.BaseService;
import com.example.salesproject.util.IBaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService extends
        BaseService<PersonEntity, PersonDTO, PersonRequestDTO, PersonMapper, PersonRepository, PersonSpecification> {

    @Autowired
    PersonRepository personEntityRepository;

    @Autowired
    PersonMapper personMapper;

    @Override
    protected PersonMapper getMapper() {
        return this.personMapper;
    }

    @Override
    protected PersonRepository getRepository() {
        return this.personEntityRepository;
    }

    @Override
    protected PersonSpecification getSpecification() {
        return null;
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
