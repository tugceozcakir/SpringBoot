package com.tugceozcakir.erpsystem.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Order {
    private Long id;
    private Customer customer;
    private List<OrderItem> orderItems;
    private OrderStatus status;
}
