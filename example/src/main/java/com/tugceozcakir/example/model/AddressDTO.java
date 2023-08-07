package com.tugceozcakir.example.model;

import com.tugceozcakir.example.util.BaseDTO;
import lombok.Data;

@Data

public class AddressDTO extends BaseDTO {

    private String title;
    private String address;

    //private PersonDTO person;

}