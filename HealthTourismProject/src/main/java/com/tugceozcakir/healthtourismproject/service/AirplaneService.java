package com.tugceozcakir.healthtourismproject.service;

import com.tugceozcakir.healthtourismproject.database.entity.AirlineCompanyEntity;
import com.tugceozcakir.healthtourismproject.database.entity.AirplaneEntity;
import com.tugceozcakir.healthtourismproject.database.entity.RoomEntity;
import com.tugceozcakir.healthtourismproject.database.repository.AirplaneRepository;
import com.tugceozcakir.healthtourismproject.database.specification.AirlineCompanySpecification;
import com.tugceozcakir.healthtourismproject.database.specification.AirplaneSpecification;
import com.tugceozcakir.healthtourismproject.mapper.AirplaneMapper;
import com.tugceozcakir.healthtourismproject.model.AirlineCompanyDTO;
import com.tugceozcakir.healthtourismproject.model.AirplaneDTO;
import com.tugceozcakir.healthtourismproject.model.RoomDTO;
import com.tugceozcakir.healthtourismproject.model.requestDTO.AirplaneRequestDTO;
import com.tugceozcakir.healthtourismproject.util.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AirplaneService extends BaseService<
        AirplaneEntity,
        AirplaneDTO,
        AirplaneRequestDTO,
        AirplaneMapper,
        AirplaneRepository,
        AirplaneSpecification> {

    @Autowired
    AirplaneMapper airplaneMapper;

    @Autowired
    AirplaneRepository airplaneRepository;

    @Autowired
    AirplaneSpecification airplaneSpecification;

    @Autowired
    ReservationService reservationService;

    @Override
    protected AirplaneMapper getMapper() {
        return airplaneMapper;
    }

    @Override
    protected AirplaneRepository getRepository() {
        return airplaneRepository;
    }

    @Override
    protected AirplaneSpecification getSpecification() {
        return airplaneSpecification;
    }

    public ResponseEntity<AirplaneDTO> selectAirplane(Long id) {
        AirplaneEntity entity = getRepository().findById(id).orElse(null);
        if (entity != null) {
            reservationService.makeReservationForAirplane(entity);
            return new ResponseEntity<>(getMapper().entityToDTO(entity), HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
