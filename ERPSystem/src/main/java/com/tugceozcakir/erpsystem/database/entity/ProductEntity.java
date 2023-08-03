package com.tugceozcakir.erpsystem.database.entity;

import com.tugceozcakir.erpsystem.util.dbutil.BaseEntity;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "product")
@AttributeOverride(name = "uuid", column = @Column(name = "product_uuid"))
@Data
public class ProductEntity extends BaseEntity {
    @Column(name = "product_name")
    private String name;
    @Column(name = "product_price")
    private double price;

    @Column(name = "tax_rate")
    private double taxRate;

    @Column(name = "stock_quantity")
    private int stockQuantity;

}

