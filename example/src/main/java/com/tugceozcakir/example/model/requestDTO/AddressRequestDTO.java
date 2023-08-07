package com.tugceozcakir.example.model.requestDTO;

import com.tugceozcakir.example.util.BaseDTO;
import lombok.Data;

@Data
public class AddressRequestDTO extends BaseDTO {

    private String title;
    private String address;
}