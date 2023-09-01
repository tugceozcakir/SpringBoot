package com.tugceozcakir.healthtourismproject.model.requestDTO;

import com.tugceozcakir.healthtourismproject.database.entity.AvailabilityEntity;
import com.tugceozcakir.healthtourismproject.database.entity.HospitalEntity;
import com.tugceozcakir.healthtourismproject.database.entity.ReportEntity;
import com.tugceozcakir.healthtourismproject.database.entity.ReservationEntity;
import com.tugceozcakir.healthtourismproject.util.BaseDTO;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class DoctorRequestDTO extends BaseDTO {
    private String name;
    private String surname;
    private String email;
    private String password;
    private BigDecimal doctorFee;
    private List<AvailabilityRequestDTO> appointmentTime;
    private String inspectionTimes;
    private List<ReportRequestDTO> reports;
}
