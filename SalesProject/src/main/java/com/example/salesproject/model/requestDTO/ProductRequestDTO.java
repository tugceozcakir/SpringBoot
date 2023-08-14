package com.example.salesproject.model.requestDTO;

import com.example.salesproject.model.enums.ColorEnum;
import com.example.salesproject.util.BaseDTO;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Set;

@Data
public class ProductRequestDTO extends BaseDTO {

    private String name;
    private String code;
    private ColorEnum color;
    private BigDecimal sellPrice;
    private BigDecimal buyPrice;
    private Integer quantity;
    private Set<CategoryRequestDTO> categoryList;
    private TaxRequestDTO tax;

}

