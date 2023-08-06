package com.tugceozcakir.erpsystem.service;

import com.tugceozcakir.erpsystem.database.entity.ProductEntity;
import com.tugceozcakir.erpsystem.database.entity.TaxEntity;
import com.tugceozcakir.erpsystem.database.repository.TaxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service
public class TaxService {
    @Autowired
    TaxRepository taxRepository;
    public boolean createTax(String name, Double percent) {
        if (name == null || percent == null)
            return false;
        else {
            TaxEntity taxEntity = new TaxEntity();
            taxEntity.setName(name);
            taxEntity.setPercent(percent);
            taxRepository.save(taxEntity);
            return true;
        }
    }
    public List<TaxEntity> getAll() {
        return taxRepository.findAll();
    }
    public boolean deleteKdv(UUID uuid) {
        if (uuid == null)
            return false;
        taxRepository.deleteByUuid(uuid);
        return true;
    }
    public boolean updateTax(UUID uuid, TaxEntity kdvEntity) {
        if (uuid == null || kdvEntity == null)
            return false;
        else {
            TaxEntity existingTax = taxRepository.findByUuid(uuid);
            if (existingTax == null)
                return false;
            existingTax.setName(kdvEntity.getName());
            existingTax.setPercent(kdvEntity.getPercent());
            taxRepository.save(existingTax);
            return true;
        }
    }
}

