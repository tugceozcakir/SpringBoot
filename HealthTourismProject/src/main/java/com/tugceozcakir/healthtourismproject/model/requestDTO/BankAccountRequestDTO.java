package com.tugceozcakir.healthtourismproject.model.requestDTO;

import com.tugceozcakir.healthtourismproject.database.entity.UserEntity;
import com.tugceozcakir.healthtourismproject.util.BaseDTO;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class BankAccountRequestDTO extends BaseDTO {
    private String name;
    private String iban;
    private BigDecimal amount;
}
