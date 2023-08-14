package com.example.salesproject.model.requestDTO;

import com.example.salesproject.util.BaseDTO;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class TaxRequestDTO extends BaseDTO {
    private String name;
    private String code;
    private BigDecimal rate;
}

