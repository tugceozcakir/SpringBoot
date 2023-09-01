package com.tugceozcakir.healthtourismproject.model;

import com.tugceozcakir.healthtourismproject.database.entity.UserEntity;
import com.tugceozcakir.healthtourismproject.util.BaseDTO;
import lombok.Data;

@Data
public class ReportDTO extends BaseDTO {
    private String report;
    //private UserEntity user;
}
