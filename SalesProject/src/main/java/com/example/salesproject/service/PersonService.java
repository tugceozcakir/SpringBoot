package com.example.salesproject.service;

import com.example.salesproject.database.entity.PersonEntity;
import com.example.salesproject.database.repository.PersonRepository;
import com.example.salesproject.mapper.PersonMapper;
import com.example.salesproject.model.PersonDTO;
import com.example.salesproject.model.requestDTO.PersonRequestDTO;
import com.example.salesproject.util.BaseRepository;
import com.example.salesproject.util.BaseService;
import com.example.salesproject.util.IBaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService extends
        BaseService<PersonEntity, PersonDTO, PersonRequestDTO, PersonMapper, PersonRepository> {

   @Autowired
   PersonMapper personMapper;

   @Autowired
   PersonRepository personRepository;

    @Override
    public PersonMapper getMapper() {
        return personMapper;
    }

    @Override
    public PersonRepository getRepository() {
        return personRepository;
    }
}
