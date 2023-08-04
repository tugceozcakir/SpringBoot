package com.tugceozcakir.erpsystem.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderItem {
    private Long id;
    private Product product;
    private int quantity;
    private double unitPrice; //The current unit price of the product
    private double taxAmount; //VAT amount determined for the product

}
