package com.tugceozcakir.example.model;

import com.tugceozcakir.example.util.BaseDTO;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Data
public class PersonDTO extends BaseDTO {

    private String name;
    private String surname;
    private int birthYear;
    private String tc;
    private List<AddressDTO> addressList;
}
