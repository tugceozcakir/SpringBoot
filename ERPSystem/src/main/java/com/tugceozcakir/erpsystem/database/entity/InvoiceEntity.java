package com.tugceozcakir.erpsystem.database.entity;

import com.tugceozcakir.erpsystem.util.dbutil.BaseEntity;
import jakarta.persistence.*;
import jakarta.persistence.criteria.Order;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Table(name = "invoice")
@AttributeOverride(name = "uuid", column = @Column(name = "invoice_uuid"))
@Data
public class InvoiceEntity extends BaseEntity {
    @OneToOne
    @JoinColumn(name = "order_id", unique = false)
    private OrderEntity order;

    @Column
    private BigDecimal totalPrice;
}


