package com.tugceozcakir.healthtourismproject.model.requestDTO;

import com.tugceozcakir.healthtourismproject.util.BaseDTO;
import jakarta.persistence.Column;
import lombok.Data;

@Data
public class AdminRequestDTO extends BaseDTO {
    private String email;
    private String password;
}
