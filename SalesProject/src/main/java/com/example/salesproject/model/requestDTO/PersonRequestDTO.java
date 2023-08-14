package com.example.salesproject.model.requestDTO;

import com.example.salesproject.util.BaseDTO;
import lombok.Data;

@Data
public class PersonRequestDTO extends BaseDTO {

    private String name;
    private String surname;
    private int birthYear;
    private String tc;

}
