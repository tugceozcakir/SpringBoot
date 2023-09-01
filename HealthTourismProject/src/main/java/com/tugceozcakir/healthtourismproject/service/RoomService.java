package com.tugceozcakir.healthtourismproject.service;

import com.tugceozcakir.healthtourismproject.database.entity.ReservationEntity;
import com.tugceozcakir.healthtourismproject.database.entity.RoomEntity;
import com.tugceozcakir.healthtourismproject.database.repository.RoomRepository;
import com.tugceozcakir.healthtourismproject.database.specification.RoomSpecification;
import com.tugceozcakir.healthtourismproject.mapper.RoomMapper;
import com.tugceozcakir.healthtourismproject.model.RoomDTO;
import com.tugceozcakir.healthtourismproject.model.requestDTO.RoomRequestDTO;
import com.tugceozcakir.healthtourismproject.util.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class RoomService extends BaseService<
        RoomEntity,
        RoomDTO,
        RoomRequestDTO,
        RoomMapper,
        RoomRepository,
        RoomSpecification
        > {

    @Autowired
    RoomMapper roomMapper;

    @Autowired
    RoomRepository roomRepository;

    @Autowired
    RoomSpecification roomSpecification;

    @Autowired
    ReservationService reservationService;

    @Override
    protected RoomMapper getMapper() {
        return roomMapper;
    }

    @Override
    protected RoomRepository getRepository() {
        return roomRepository;
    }

    @Override
    protected RoomSpecification getSpecification() {
        return roomSpecification;
    }

    public ResponseEntity<RoomDTO> selectRoom(Long id) {
        RoomEntity entity = getRepository().findById(id).orElse(null);
        if (entity != null) {
            reservationService.makeReservationForRoom(entity);
            return new ResponseEntity<>(getMapper().entityToDTO(entity), HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
