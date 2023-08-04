package com.tugceozcakir.erpsystem.controller;

import com.tugceozcakir.erpsystem.database.entity.ProductEntity;
import com.tugceozcakir.erpsystem.database.entity.TaxEntity;
import com.tugceozcakir.erpsystem.service.ProductService;
import com.tugceozcakir.erpsystem.service.TaxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tax")
public class TaxController {

    private final TaxService taxService;

    @Autowired
    public TaxController(TaxService taxService) {
        this.taxService = taxService;
    }

    @PostMapping("/add-tax")
    public TaxEntity addTax(@RequestBody TaxEntity tax) {
        return taxService.addTax(tax);
    }
}