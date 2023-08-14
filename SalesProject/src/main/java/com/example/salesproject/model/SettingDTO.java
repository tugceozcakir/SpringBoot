package com.example.salesproject.model;

import com.example.salesproject.util.BaseDTO;
import lombok.Data;

@Data
public class SettingDTO extends BaseDTO {
    private String key;
    private String value;
}
