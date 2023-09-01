package com.tugceozcakir.healthtourismproject.database.entity;

import com.tugceozcakir.healthtourismproject.model.enums.ReservationStatus;
import com.tugceozcakir.healthtourismproject.util.dbUtil.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "reservation")
@Data
@AttributeOverride(
        name = "uuid",
        column = @Column(
                name = "reservation_uuid"
        )
)
public class ReservationEntity extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private RoomEntity room;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private DoctorEntity doctor;

    @ManyToOne
    @JoinColumn(name = "airplane_id")
    private AirplaneEntity airplane;

    @Column
    private LocalDateTime reservationTime;

    @Column
    private LocalDateTime cancellationTime;
}