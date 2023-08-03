package com.tugceozcakir.erpsystem.database.entity;

import com.tugceozcakir.erpsystem.util.dbutil.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "invoice")
@AttributeOverride(name = "uuid", column = @Column(name = "invoice_uuid"))
@Data
public class InvoiceEntity extends BaseEntity {
    @OneToOne
    private OrderEntity order;

    @Column(name = "total_amount")
    private double totalAmount;

    @Column(name = "invoice_number")
    private String invoiceNumber;

}

