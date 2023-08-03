package com.tugceozcakir.erpsystem.controller;

import com.tugceozcakir.erpsystem.database.entity.InvoiceEntity;
import com.tugceozcakir.erpsystem.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/invoices")
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;


    @PostMapping("/create")
    public InvoiceEntity createInvoice(@RequestBody InvoiceEntity invoice) {
        return invoiceService.createInvoice(invoice.getOrder(), invoice.getTotalAmount(), invoice.getInvoiceNumber());
    }
}
