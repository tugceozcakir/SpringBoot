package com.example.salesproject.model;

import com.example.salesproject.util.BaseDTO;
import lombok.Data;

@Data
public class SellerDTO extends BaseDTO {

    private String name;
    private String surname;
    private String tc;
    private String email;
    private String shopName;
    private String taxNumber;
    private String taxOffice;

}

