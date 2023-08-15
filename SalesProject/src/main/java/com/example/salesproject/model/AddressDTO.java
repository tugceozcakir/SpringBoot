package com.example.salesproject.model;

import com.example.salesproject.util.BaseDTO;
import lombok.Data;

@Data
public class AddressDTO extends BaseDTO {

    private String title;
    private String address;

    private PersonDTO person;

}
