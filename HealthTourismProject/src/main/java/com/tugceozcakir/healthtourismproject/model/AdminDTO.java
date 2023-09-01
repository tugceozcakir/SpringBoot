package com.tugceozcakir.healthtourismproject.model;

import com.tugceozcakir.healthtourismproject.util.BaseDTO;
import jakarta.persistence.Column;
import lombok.Data;

@Data
public class AdminDTO extends BaseDTO {
    private String email;
    private String password;
}
