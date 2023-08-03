package com.tugceozcakir.erpsystem.database.entity;

import com.tugceozcakir.erpsystem.util.dbutil.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "orderitem")
@AttributeOverride(name = "uuid", column = @Column(name = "orderitem_uuid"))
@Data
public class OrderItemEntity extends BaseEntity {
    @ManyToOne
    private ProductEntity product;

    private int quantity;

    @Column(name = "unit_price")
    private double unitPrice;

    @Column(name = "tax_amount")
    private double taxAmount;

    @ManyToOne
    private OrderEntity order;
}

