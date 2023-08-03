package com.tugceozcakir.erpsystem.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    private Long id;
    private String name;
    private double price;
    private double taxRate;
    private int stockQuantity;
}

