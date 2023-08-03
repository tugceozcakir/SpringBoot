package com.tugceozcakir.erpsystem.database.entity;

import com.tugceozcakir.erpsystem.model.OrderItem;
import com.tugceozcakir.erpsystem.model.OrderStatus;
import com.tugceozcakir.erpsystem.util.dbutil.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "order")
@AttributeOverride(name = "uuid", column = @Column(name = "order_uuid"))
@Data
public class OrderEntity extends BaseEntity {
    @ManyToOne
    private CustomerEntity customer;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "order")
    private List<OrderItemEntity> orderItems;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;
}

