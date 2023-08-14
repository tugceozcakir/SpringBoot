package com.example.salesproject.model.requestDTO;

import com.example.salesproject.util.BaseDTO;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class CategoryRequestDTO extends BaseDTO {
    private String name;
    private Set<ProductRequestDTO> productList = new HashSet<>();
}
