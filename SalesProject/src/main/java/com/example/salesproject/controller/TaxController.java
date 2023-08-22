package com.example.salesproject.controller;

import com.example.salesproject.database.entity.TaxEntity;
import com.example.salesproject.database.repository.TaxRepository;
import com.example.salesproject.database.specification.TaxSpecification;
import com.example.salesproject.mapper.TaxMapper;
import com.example.salesproject.model.TaxDTO;
import com.example.salesproject.model.requestDTO.TaxRequestDTO;
import com.example.salesproject.service.TaxService;
import com.example.salesproject.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("tax")
public class TaxController extends BaseController<
        TaxEntity,
        TaxDTO,
        TaxRequestDTO,
        TaxMapper,
        TaxRepository,
        TaxSpecification,
        TaxService>   {

    @Autowired
    TaxService taxService;
    @Override
    protected TaxService getService() {
        return taxService;
    }

}

