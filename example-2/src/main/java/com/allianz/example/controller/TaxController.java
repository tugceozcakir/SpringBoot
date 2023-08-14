package com.allianz.example.controller;

import com.allianz.example.database.entity.TaxEntity;
import com.allianz.example.database.repository.TaxEntityRepository;
import com.allianz.example.mapper.TaxMapper;
import com.allianz.example.model.TaxDTO;
import com.allianz.example.model.requestDTO.TaxRequestDTO;
import com.allianz.example.service.TaxService;
import com.allianz.example.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("taxes")
public class TaxController extends BaseController<TaxEntity, TaxDTO, TaxRequestDTO, TaxService>{

    @Autowired
    TaxService taxService;
    @Override
    protected TaxService getService() {
        return taxService;
    }

}