package com.example.salesproject.model.requestDTO;

import com.example.salesproject.model.PersonDTO;
import com.example.salesproject.util.BaseDTO;
import lombok.Data;

import java.util.List;

@Data
public class CustomerRequestDTO extends BaseDTO {
    private PersonDTO person;
    private Boolean isCorporate;
    private String companyName;
    private String taxNumber;
    private String taxOffice;
    private List<OrderRequestDTO> orderList;

}

