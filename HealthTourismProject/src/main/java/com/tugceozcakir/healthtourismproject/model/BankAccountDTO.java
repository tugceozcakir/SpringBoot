package com.tugceozcakir.healthtourismproject.model;

import com.tugceozcakir.healthtourismproject.database.entity.UserEntity;
import com.tugceozcakir.healthtourismproject.util.BaseDTO;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class BankAccountDTO extends BaseDTO {
    private String name;
    private String iban;
    private BigDecimal amount;
}
