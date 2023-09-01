package com.tugceozcakir.healthtourismproject.model.requestDTO;

import com.tugceozcakir.healthtourismproject.database.entity.AirplaneEntity;
import com.tugceozcakir.healthtourismproject.database.entity.DoctorEntity;
import com.tugceozcakir.healthtourismproject.database.entity.RoomEntity;
import com.tugceozcakir.healthtourismproject.database.entity.UserEntity;
import com.tugceozcakir.healthtourismproject.database.repository.DoctorRepository;
import com.tugceozcakir.healthtourismproject.database.repository.UserRepository;
import com.tugceozcakir.healthtourismproject.model.enums.ReservationStatus;
import com.tugceozcakir.healthtourismproject.util.BaseDTO;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class ReservationRequestDTO extends BaseDTO {
    private UserRequestDTO user;
    private RoomRequestDTO room;
    private DoctorRequestDTO doctor;
    private AirplaneRequestDTO airplane;
    private LocalDateTime reservationTime;
}
