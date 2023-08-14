package com.example.salesproject.database.entity;

import com.example.salesproject.model.enums.OrderStatusEnum;
import com.example.salesproject.util.dbutil.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@Entity
@Table
public class OrderEntity extends BaseEntity {


    @ManyToOne
    private CustomerEntity customer;

    @Enumerated(EnumType.STRING)
    private OrderStatusEnum orderStatus;

    @OneToMany
    private List<OrderItemEntity> orderItemList;

    @Column
    private BigDecimal totalSellPrice;




}
