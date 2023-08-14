package com.allianz.example.service;

import com.allianz.example.database.entity.PersonEntity;
import com.allianz.example.database.entity.ProductEntity;
import com.allianz.example.database.entity.TaxEntity;
import com.allianz.example.database.repository.PersonEntityRepository;
import com.allianz.example.database.repository.ProductEntityRepository;
import com.allianz.example.mapper.PersonMapper;
import com.allianz.example.mapper.ProductMapper;
import com.allianz.example.model.PersonDTO;
import com.allianz.example.model.ProductDTO;
import com.allianz.example.model.TaxDTO;
import com.allianz.example.model.requestDTO.PersonRequestDTO;
import com.allianz.example.model.requestDTO.ProductRequestDTO;
import com.allianz.example.model.requestDTO.TaxRequestDTO;
import com.allianz.example.util.BaseService;
import com.allianz.example.util.IBaseMapper;
import com.allianz.example.util.IBaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

//bean
@Service
public class PersonService extends BaseService<PersonEntity, PersonDTO,
        PersonRequestDTO, IBaseMapper<PersonDTO, PersonEntity, PersonRequestDTO>, IBaseRepository<PersonEntity>> {

    @Autowired
    private PersonMapper personMapper;

    @Autowired
    private PersonEntityRepository personEntityRepository;

    @Override
    public PersonMapper getMapper() {
        return personMapper;
    }

    @Override
    public PersonEntityRepository getRepository() {
        return personEntityRepository;
    }
}
