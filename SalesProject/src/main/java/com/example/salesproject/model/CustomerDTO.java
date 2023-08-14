package com.example.salesproject.model;

import com.example.salesproject.util.BaseDTO;
import lombok.Data;

import java.util.List;

@Data
public class CustomerDTO extends BaseDTO {
    private PersonDTO person;
    private Boolean isCorporate;
    private String companyName;
    private String taxNumber;
    private String taxOffice;
    private List<OrderDTO> orderList;

}
