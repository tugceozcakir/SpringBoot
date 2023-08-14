package com.example.salesproject.model;

import com.example.salesproject.util.BaseDTO;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class CategoryDTO extends BaseDTO {
    private String name;
    private Set<ProductDTO> productList = new HashSet<>();
}
