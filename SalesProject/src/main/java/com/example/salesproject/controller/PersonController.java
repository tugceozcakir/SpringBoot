package com.example.salesproject.controller;

import com.example.salesproject.database.entity.PersonEntity;
import com.example.salesproject.database.repository.PersonRepository;
import com.example.salesproject.mapper.PersonMapper;
import com.example.salesproject.model.PersonDTO;
import com.example.salesproject.model.requestDTO.PersonRequestDTO;
import com.example.salesproject.service.PersonService;
import com.example.salesproject.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
public class PersonController extends BaseController<
        PersonEntity,
        PersonDTO,
        PersonRequestDTO,
        PersonMapper,
        PersonRepository,
        PersonService> {
   @Autowired
   PersonService personService;


    @Override
    protected PersonService getService() {
        return personService;
    }
}
