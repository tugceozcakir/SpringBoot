package com.tugceozcakir.healthtourismproject.controller;

import com.tugceozcakir.healthtourismproject.database.entity.RoomEntity;
import com.tugceozcakir.healthtourismproject.database.repository.RoomRepository;
import com.tugceozcakir.healthtourismproject.database.specification.RoomSpecification;
import com.tugceozcakir.healthtourismproject.mapper.RoomMapper;
import com.tugceozcakir.healthtourismproject.model.AirplaneDTO;
import com.tugceozcakir.healthtourismproject.model.RoomDTO;
import com.tugceozcakir.healthtourismproject.model.requestDTO.RoomRequestDTO;
import com.tugceozcakir.healthtourismproject.service.RoomService;
import com.tugceozcakir.healthtourismproject.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/room")
public class RoomController extends BaseController<
        RoomEntity,
        RoomDTO,
        RoomRequestDTO,
        RoomMapper,
        RoomRepository,
        RoomSpecification,
        RoomService> {

    @Autowired
    RoomService roomService;

    @Override
    protected RoomService getService() {
        return roomService;
    }

    @GetMapping("select/{id}")
    public ResponseEntity<RoomDTO> selectAirplane(@PathVariable Long id) {
        return roomService.selectRoom(id);
    }
}
