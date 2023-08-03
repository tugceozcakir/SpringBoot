package com.tugceozcakir.erpsystem.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Invoice {
    private Long id;
    private Order order;
    private double totalAmount;
    private String invoiceNumber;
}

