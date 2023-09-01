package com.tugceozcakir.healthtourismproject.model;

import com.tugceozcakir.healthtourismproject.database.entity.DoctorEntity;
import com.tugceozcakir.healthtourismproject.database.entity.RoomEntity;
import com.tugceozcakir.healthtourismproject.util.BaseDTO;
import lombok.Data;

import java.util.List;

@Data
public class HospitalDTO extends BaseDTO {
    private String name;
    private String city;
    private String address;
    private String contactNumber;
    private List<DoctorDTO> doctors;
}
