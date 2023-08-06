package com.tugceozcakir.erpsystem.controller;

import com.tugceozcakir.erpsystem.database.entity.InvoiceEntity;
import com.tugceozcakir.erpsystem.service.InvoiceService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("invoices")
public class InvoiceController {
    @Autowired
    InvoiceService invoiceService;

    @PostMapping("/create-invoice")
    public ResponseEntity<Boolean> createInvoice(@RequestBody InvoiceEntity invoiceEntity) {
        boolean isInvoiceCreated = invoiceService.createInvoice(invoiceEntity.getOrder().getId(),
                invoiceEntity.getTotalPrice());
        if (isInvoiceCreated) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/all-invoice")
    public ResponseEntity<List<InvoiceEntity>> getAll() {
        return new ResponseEntity<>(invoiceService.getAll(), HttpStatus.OK);
    }
    @GetMapping("get/{uuid}")
    public ResponseEntity<InvoiceEntity> getByUuid(@PathVariable UUID uuid) {
        return new ResponseEntity<>(invoiceService.getByUuid(uuid), HttpStatus.OK);
    }
    @Modifying
    @Transactional
    @DeleteMapping("delete-invoice/{uuid}")
    public ResponseEntity<Boolean> deleteInvoiceUuid(@PathVariable UUID uuid) {
        return new ResponseEntity<>(invoiceService.deleteInvoice(uuid), HttpStatus.OK);
    }
    @Modifying
    @Transactional
    @PutMapping("update-invoice/{uuid}")
    public ResponseEntity<Boolean> updateInvoiceUuid(@PathVariable UUID uuid, @RequestBody InvoiceEntity invoiceEntity) {
        InvoiceEntity newInvoice = new InvoiceEntity();
        newInvoice.setOrder(invoiceEntity.getOrder());
        newInvoice.setTotalPrice(invoiceEntity.getTotalPrice());
        return new ResponseEntity<>(invoiceService.updateInvoice(uuid, newInvoice), HttpStatus.OK);
    }
}