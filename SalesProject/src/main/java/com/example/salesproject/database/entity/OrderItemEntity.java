package com.example.salesproject.database.entity;

import com.example.salesproject.util.dbutil.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
@Table
public class OrderItemEntity extends BaseEntity {


    @ManyToOne(fetch = FetchType.LAZY)
    private ProductEntity product;

    @Column
    private Integer quantity;

    @Column
    private BigDecimal sellPrice;

}