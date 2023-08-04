package com.tugceozcakir.erpsystem.service;

import com.tugceozcakir.erpsystem.database.entity.ProductEntity;
import com.tugceozcakir.erpsystem.database.entity.TaxEntity;
import com.tugceozcakir.erpsystem.database.repository.TaxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class TaxService {

    private final TaxRepository taxRepository;

    @Autowired
    public TaxService(TaxRepository taxRepository) {
        this.taxRepository = taxRepository;
    }

    public TaxEntity getTaxById(Long taxId) {
        return taxRepository.findById(taxId)
                .orElseThrow(() -> new NoSuchElementException("Tax not found with ID: " + taxId));
    }

    public TaxEntity addTax(TaxEntity tax) {
        return taxRepository.save(tax);
    }
}

