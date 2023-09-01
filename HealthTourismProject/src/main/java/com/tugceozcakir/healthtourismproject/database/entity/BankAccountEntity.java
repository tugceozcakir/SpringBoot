package com.tugceozcakir.healthtourismproject.database.entity;

import com.tugceozcakir.healthtourismproject.util.dbUtil.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "bank_accounts")
@Data
public class BankAccountEntity extends BaseEntity {
    @Column
    private String name;
    @Column
    private String iban;
    @Column
    private BigDecimal amount;
}
