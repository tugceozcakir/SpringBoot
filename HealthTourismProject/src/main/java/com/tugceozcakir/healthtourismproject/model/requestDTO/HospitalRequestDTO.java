package com.tugceozcakir.healthtourismproject.model.requestDTO;

import com.tugceozcakir.healthtourismproject.database.entity.DoctorEntity;
import com.tugceozcakir.healthtourismproject.util.BaseDTO;
import lombok.Data;

import java.util.List;

@Data
public class HospitalRequestDTO extends BaseDTO {
    private String name;
    private String city;
    private String address;
    private String contactNumber;
    private List<DoctorRequestDTO> doctors;
}
