package com.tugceozcakir.healthtourismproject.controller;

import com.tugceozcakir.healthtourismproject.database.entity.*;
import com.tugceozcakir.healthtourismproject.database.repository.ReservationRepository;
import com.tugceozcakir.healthtourismproject.database.specification.ReservationSpecification;
import com.tugceozcakir.healthtourismproject.mapper.ReservationMapper;
import com.tugceozcakir.healthtourismproject.model.ReservationDTO;
import com.tugceozcakir.healthtourismproject.model.requestDTO.ReservationRequestDTO;
import com.tugceozcakir.healthtourismproject.service.*;
import com.tugceozcakir.healthtourismproject.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/reservation")
public class ReservationController extends BaseController<
        ReservationEntity,
        ReservationDTO,
        ReservationRequestDTO,
        ReservationMapper,
        ReservationRepository,
        ReservationSpecification,
        ReservationService> {

    @Autowired
    ReservationService reservationService;

    @Autowired
    UserService userService;

    @Autowired
    RoomService roomService;

    @Autowired
    DoctorService doctorService;

    @Autowired
    AirplaneService airplaneService;

    @Override
    protected ReservationService getService() {
        return reservationService;
    }

    @PostMapping("/make")
    public ResponseEntity<String> makeReservation(
            @RequestParam Long userId,
            @RequestParam Long roomId,
            @RequestParam Long doctorId,
            @RequestParam Long airplaneId) {

        UserEntity user = userService.findById(userId);
        RoomEntity room = roomService.findById(roomId);
        DoctorEntity doctor = doctorService.findById(doctorId);
        AirplaneEntity airplane = airplaneService.findById(airplaneId);

        boolean success = reservationService.makeReservation(user, room, doctor, airplane);

        if (success) {
            return ResponseEntity.ok("Reservation made successfully.");
        } else {
            return ResponseEntity.badRequest().body("Insufficient funds.");
        }
    }
}
