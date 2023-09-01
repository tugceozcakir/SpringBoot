package com.tugceozcakir.healthtourismproject.model;

import com.tugceozcakir.healthtourismproject.database.entity.AvailabilityEntity;
import com.tugceozcakir.healthtourismproject.database.entity.HospitalEntity;
import com.tugceozcakir.healthtourismproject.database.entity.ReportEntity;
import com.tugceozcakir.healthtourismproject.database.entity.ReservationEntity;
import com.tugceozcakir.healthtourismproject.util.BaseDTO;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class DoctorDTO extends BaseDTO {
    private String name;
    private String surname;
    private String email;
    private String password;
    private BigDecimal doctorFee;
    private List<AvailabilityDTO> appointmentTime;
    private String inspectionTimes;
    private List<ReportDTO> reports;
}
