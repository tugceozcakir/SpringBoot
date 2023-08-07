package com.tugceozcakir.example.model.requestDTO;

import com.tugceozcakir.example.util.BaseDTO;
import lombok.Data;

@Data
public class PersonRequestDTO extends BaseDTO {

    private String name;
    private String surname;
    private int birthYear;
    private String tc;

}
