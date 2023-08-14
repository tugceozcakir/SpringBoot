package com.example.salesproject.model;

import com.example.salesproject.util.BaseDTO;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderItemDTO extends BaseDTO {
    private ProductDTO product;
    private Integer quantity;
    private BigDecimal sellPrice;
}
