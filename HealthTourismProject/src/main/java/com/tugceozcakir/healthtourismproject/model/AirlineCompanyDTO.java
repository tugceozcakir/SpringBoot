package com.tugceozcakir.healthtourismproject.model;

import com.tugceozcakir.healthtourismproject.database.entity.AirplaneEntity;
import com.tugceozcakir.healthtourismproject.util.BaseDTO;
import lombok.Data;

import java.util.List;

@Data
public class AirlineCompanyDTO extends BaseDTO {
    private String companyName;
    private String contactNumber;
    private List<AirplaneDTO> airplaneEntityList;
}
