package com.tugceozcakir.erpsystem.database.entity;

import com.tugceozcakir.erpsystem.util.StatusEnum;
import com.tugceozcakir.erpsystem.util.dbutil.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table
@Data
@AttributeOverride(name = "uuid", column = @Column(name = "order_uuid"))
public class OrderEntity extends BaseEntity {
    @OneToOne
    @JoinColumn(name = "customer_id", unique = false)
    private CustomerEntity customer;

    @ManyToMany
    @JoinColumn(name = "product_id", unique = false)
    private List<ProductEntity> productList = new ArrayList<>();

    @Column
    private StatusEnum status = StatusEnum.WAITING;

    @Column
    private BigDecimal totalPrice;
}