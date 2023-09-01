package com.tugceozcakir.healthtourismproject.database.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tugceozcakir.healthtourismproject.model.enums.Sex;
import com.tugceozcakir.healthtourismproject.util.dbUtil.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Data
@AttributeOverride(
        name = "uuid",
        column = @Column(
                name = "users_uuid"
        )
)
public class UserEntity extends BaseEntity {
    @Column
    private String name;

    @Column
    private String surname;

    @Column
    private String email;

    @Column
    private String password;

    @Column
    private Sex sex;

    @Column
    private LocalDate birthday;

    @Column
    private String mobileNumber;

    @OneToMany
    private List<BankAccountEntity> bankAccounts;

    @OneToMany
    private List<ReportEntity> doctorReports;
}
