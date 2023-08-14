package com.example.salesproject.model.requestDTO;

import com.example.salesproject.util.BaseDTO;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderItemRequestDTO extends BaseDTO {
    private ProductRequestDTO product;
    private Integer quantity;
    private BigDecimal sellPrice;
}