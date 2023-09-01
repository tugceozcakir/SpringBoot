package com.tugceozcakir.healthtourismproject.model.requestDTO;

import com.tugceozcakir.healthtourismproject.database.entity.AirplaneEntity;
import com.tugceozcakir.healthtourismproject.util.BaseDTO;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Data
public class AirlineCompanyRequestDTO extends BaseDTO {
    private String companyName;
    private String contactNumber;
    private List<AirplaneRequestDTO> airplaneEntityList;
}
