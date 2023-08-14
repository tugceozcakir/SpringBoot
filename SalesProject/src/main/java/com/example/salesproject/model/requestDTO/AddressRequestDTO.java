package com.example.salesproject.model.requestDTO;

import com.example.salesproject.util.BaseDTO;
import lombok.Data;

@Data
public class AddressRequestDTO extends BaseDTO {

    private String title;
    private String address;
}
