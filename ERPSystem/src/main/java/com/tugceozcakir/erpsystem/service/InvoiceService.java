package com.tugceozcakir.erpsystem.service;

import com.tugceozcakir.erpsystem.database.entity.InvoiceEntity;
import com.tugceozcakir.erpsystem.database.entity.OrderEntity;
import com.tugceozcakir.erpsystem.database.repository.InvoiceRepository;
import com.tugceozcakir.erpsystem.database.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Service
public class InvoiceService {
    @Autowired
    InvoiceRepository invoiceRepository;
    @Autowired
    OrderRepository orderRepository;
    public boolean createInvoice(Long orderId, BigDecimal totalPrice) {
        if (totalPrice == null || orderId == null)
            return false;
        else {
            OrderEntity order = orderRepository.findById(orderId).orElse(null);
            if (order == null) {
                return false;
            }else {
                InvoiceEntity invoiceEntity = new InvoiceEntity();
                invoiceEntity.setOrder(order);
                invoiceEntity.setTotalPrice(totalPrice);
                invoiceRepository.save(invoiceEntity);
                return true;
            }
        }
    }
    public boolean updateInvoice(UUID uuid, InvoiceEntity invoiceEntity) {
        if (uuid == null || invoiceEntity == null)
            return false;
        else {
            InvoiceEntity existingInvoice = invoiceRepository.findByUuid(uuid);
            if (existingInvoice == null){
                return false;
            }else{
                existingInvoice.setOrder(invoiceEntity.getOrder());
                existingInvoice.setTotalPrice(invoiceEntity.getTotalPrice());
                invoiceRepository.save(existingInvoice);
                return true;
            }
        }
    }
    public List<InvoiceEntity> getAll() {
        return invoiceRepository.findAll();
    }
    public InvoiceEntity getByUuid(UUID uuid) {
        return invoiceRepository.findByUuid(uuid);
    }
    public boolean deleteInvoice(UUID uuid) {
        if (uuid == null){
            return false;
        }else {
            invoiceRepository.deleteByUuid(uuid);
            return true;
        }
    }
}

