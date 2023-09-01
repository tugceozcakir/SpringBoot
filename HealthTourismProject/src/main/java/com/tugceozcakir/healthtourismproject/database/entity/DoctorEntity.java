package com.tugceozcakir.healthtourismproject.database.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tugceozcakir.healthtourismproject.util.dbUtil.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "doctor")
@Data
@AttributeOverride(
        name = "uuid",
        column = @Column(
                name = "doctor_uuid"
        )
)
public class DoctorEntity extends BaseEntity {
    @Column
    private String name;

    @Column
    private String surname;

    @Column
    private String email;

    @Column
    private String password;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "availability_id")
    private List<AvailabilityEntity> appointmentTime;

    @Column
    private BigDecimal doctorFee;

    @ManyToOne
    @JsonIgnore
    private HospitalEntity workingHospital;

    @Column
    private String inspectionTimes;

    @OneToMany
    private List<ReportEntity> doctorReports;
}
