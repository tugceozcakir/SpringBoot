package com.tugceozcakir.healthtourismproject.controller;

import com.tugceozcakir.healthtourismproject.database.entity.AirplaneEntity;
import com.tugceozcakir.healthtourismproject.database.repository.AirplaneRepository;
import com.tugceozcakir.healthtourismproject.database.specification.AirplaneSpecification;
import com.tugceozcakir.healthtourismproject.mapper.AirplaneMapper;
import com.tugceozcakir.healthtourismproject.model.AirplaneDTO;
import com.tugceozcakir.healthtourismproject.model.requestDTO.AirplaneRequestDTO;
import com.tugceozcakir.healthtourismproject.service.AirplaneService;
import com.tugceozcakir.healthtourismproject.service.ReservationService;
import com.tugceozcakir.healthtourismproject.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/airplane")
public class AirplaneController extends BaseController<
        AirplaneEntity,
        AirplaneDTO,
        AirplaneRequestDTO,
        AirplaneMapper,
        AirplaneRepository,
        AirplaneSpecification,
        AirplaneService> {

    @Autowired
    AirplaneService airplaneService;

    @Autowired
    ReservationService reservationService;

    @Override
    protected AirplaneService getService() {
        return airplaneService;
    }

    @GetMapping("select/{id}")
    public ResponseEntity<AirplaneDTO> selectAirplane(@PathVariable Long id) {
        return airplaneService.selectAirplane(id);
    }
}
