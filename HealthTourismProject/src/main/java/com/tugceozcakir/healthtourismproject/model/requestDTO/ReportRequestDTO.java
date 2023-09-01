package com.tugceozcakir.healthtourismproject.model.requestDTO;

import com.tugceozcakir.healthtourismproject.database.entity.UserEntity;
import com.tugceozcakir.healthtourismproject.util.BaseDTO;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
public class ReportRequestDTO extends BaseDTO {
    private String report;
    //private UserEntity user;
}
