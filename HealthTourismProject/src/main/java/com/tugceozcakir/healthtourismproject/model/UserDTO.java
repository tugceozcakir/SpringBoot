package com.tugceozcakir.healthtourismproject.model;

import com.tugceozcakir.healthtourismproject.database.entity.BankAccountEntity;
import com.tugceozcakir.healthtourismproject.database.entity.ReportEntity;
import com.tugceozcakir.healthtourismproject.model.enums.Sex;
import com.tugceozcakir.healthtourismproject.util.BaseDTO;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
public class UserDTO extends BaseDTO {
    private String name;
    private String surname;
    private String email;
    private String password;
    private Sex sex;
    private LocalDate birthday;
    private String mobileNumber;
    private List<BankAccountDTO> bankAccounts;
}
