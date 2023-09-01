package com.tugceozcakir.healthtourismproject.model;

import com.tugceozcakir.healthtourismproject.database.entity.AirplaneEntity;
import com.tugceozcakir.healthtourismproject.database.entity.DoctorEntity;
import com.tugceozcakir.healthtourismproject.database.entity.RoomEntity;
import com.tugceozcakir.healthtourismproject.database.entity.UserEntity;
import com.tugceozcakir.healthtourismproject.model.enums.ReservationStatus;
import com.tugceozcakir.healthtourismproject.model.requestDTO.AirplaneRequestDTO;
import com.tugceozcakir.healthtourismproject.model.requestDTO.DoctorRequestDTO;
import com.tugceozcakir.healthtourismproject.model.requestDTO.RoomRequestDTO;
import com.tugceozcakir.healthtourismproject.model.requestDTO.UserRequestDTO;
import com.tugceozcakir.healthtourismproject.util.BaseDTO;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class ReservationDTO extends BaseDTO {
    private UserDTO user;
    private RoomDTO room;
    private DoctorDTO doctor;
    private AirplaneDTO airplane;
    private LocalDateTime reservationTime;
}
