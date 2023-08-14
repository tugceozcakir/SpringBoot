package com.example.salesproject.model.requestDTO;

import com.example.salesproject.util.BaseDTO;
import lombok.Data;

@Data
public class SettingRequestDTO extends BaseDTO {
    private String key;
    private String value;
}
