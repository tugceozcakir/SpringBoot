package com.tugceozcakir.erpsystem.model;

public class OrderItem {
    private Long id;
    private Product product;
    private int quantity;
    private double unitPrice; //The current unit price of the product
    private double taxAmount; //VAT amount determined for the product

}
