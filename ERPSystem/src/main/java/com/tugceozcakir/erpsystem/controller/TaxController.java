package com.tugceozcakir.erpsystem.controller;

import com.tugceozcakir.erpsystem.database.entity.ProductEntity;
import com.tugceozcakir.erpsystem.database.entity.TaxEntity;
import com.tugceozcakir.erpsystem.service.ProductService;
import com.tugceozcakir.erpsystem.service.TaxService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("tax")
public class TaxController {
    @Autowired
    TaxService taxService;
    @PostMapping("create-tax")
    public ResponseEntity<Boolean> createKdv(@RequestBody TaxEntity tax) {
        return new ResponseEntity<>(taxService.createTax(tax.getName(), tax.getPercent()), HttpStatus.CREATED);
    }
    @Modifying
    @Transactional
    @DeleteMapping("delete-tax/{uuid}")
    public ResponseEntity<Boolean> deleteKdvByUuid(@PathVariable UUID uuid) {
        return new ResponseEntity<>(taxService.deleteKdv(uuid), HttpStatus.OK);
    }
    @GetMapping("/all-tax")
    public ResponseEntity<List<TaxEntity>> getAll() {
        return new ResponseEntity<>(taxService.getAll(), HttpStatus.OK);
    }
    @Modifying
    @Transactional
    @PutMapping("update-tax/{uuid}")
    public ResponseEntity<Boolean> updateKdvByUuid(@PathVariable UUID uuid, @RequestBody TaxEntity tax) {
        TaxEntity newTax = new TaxEntity();
        newTax.setName(tax.getName());
        newTax.setPercent(tax.getPercent());
        return new ResponseEntity<>(taxService.updateTax(uuid, newTax), HttpStatus.OK);
    }
}
