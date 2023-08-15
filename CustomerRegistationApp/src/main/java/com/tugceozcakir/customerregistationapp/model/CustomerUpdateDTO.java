package com.tugceozcakir.customerregistationapp.model;

import lombok.Data;

@Data
public class CustomerUpdateDTO {
    private Long id;
    private String name;
    private String address;
    private String mobile;
}
