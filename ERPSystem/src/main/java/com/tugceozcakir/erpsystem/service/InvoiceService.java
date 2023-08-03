package com.tugceozcakir.erpsystem.service;

import com.tugceozcakir.erpsystem.database.entity.InvoiceEntity;
import com.tugceozcakir.erpsystem.database.entity.OrderEntity;
import com.tugceozcakir.erpsystem.database.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;

    public InvoiceEntity createInvoice(OrderEntity order, double totalAmount, String invoiceNumber) {
        InvoiceEntity invoice = new InvoiceEntity();
        invoice.setOrder(order);
        invoice.setTotalAmount(totalAmount);
        invoice.setInvoiceNumber(invoiceNumber);
        return invoiceRepository.save(invoice);
    }
}

