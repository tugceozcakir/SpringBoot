package com.example.salesproject.model;

import com.example.salesproject.util.BaseDTO;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class TaxDTO extends BaseDTO {
    private String name;
    private String code;
    private BigDecimal rate;
}