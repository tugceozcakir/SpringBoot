package com.tugceozcakir.healthtourismproject.mapper;

import com.tugceozcakir.healthtourismproject.database.entity.*;
import com.tugceozcakir.healthtourismproject.model.*;
import com.tugceozcakir.healthtourismproject.model.requestDTO.ReservationRequestDTO;
import com.tugceozcakir.healthtourismproject.model.requestDTO.RoomRequestDTO;
import com.tugceozcakir.healthtourismproject.model.requestDTO.UserRequestDTO;
import com.tugceozcakir.healthtourismproject.util.IBaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ReservationMapper implements IBaseMapper<ReservationDTO, ReservationEntity, ReservationRequestDTO> {

    @Autowired
    UserMapper userMapper;

    @Autowired
    RoomMapper roomMapper;

    @Autowired
    AirplaneMapper airplaneMapper;

    @Autowired
    DoctorMapper doctorMapper;

    @Override
    public ReservationDTO entityToDTO(ReservationEntity entity) {
        ReservationDTO dto = new ReservationDTO();
        dto.setUuid(entity.getUuid());
        dto.setId(entity.getId());
        RoomDTO roomId = roomMapper.entityToDTO(entity.getRoom());
        if (roomId != null) {
            dto.setRoom(roomId);
        }
        AirplaneDTO airplaneId = airplaneMapper.entityToDTO(entity.getAirplane());
        if (airplaneId != null) {
            dto.setAirplane(airplaneId);
        }
        DoctorDTO doctorId = doctorMapper.entityToDTO(entity.getDoctor());
        if (doctorId != null) {
            dto.setDoctor(doctorId);
        }
        UserDTO userId = userMapper.entityToDTO(entity.getUser());
        if (userId != null) {
            dto.setUser(userId);
        }
        dto.setCreationDate(entity.getCreationDate());
        dto.setUpdatedDate(entity.getUpdatedDate());
        dto.setReservationTime(entity.getReservationTime());

        return dto;
    }

    @Override
    public ReservationEntity dtoToEntity(ReservationDTO dto) {
        ReservationEntity entity = new ReservationEntity();
        entity.setUuid(dto.getUuid());
        entity.setId(dto.getId());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUpdatedDate(dto.getUpdatedDate());
        RoomEntity roomId = roomMapper.dtoToEntity(dto.getRoom());
        if (roomId != null) {
            entity.setRoom(roomId);
        }
        AirplaneEntity airplaneId = airplaneMapper.dtoToEntity(dto.getAirplane());
        if (airplaneId != null) {
            entity.setAirplane(airplaneId);
        }
        DoctorEntity doctorId = doctorMapper.dtoToEntity(dto.getDoctor());
        if (doctorId != null) {
            entity.setDoctor(doctorId);
        }
        UserEntity userId = userMapper.dtoToEntity(dto.getUser());
        if (userId != null) {
            entity.setUser(userId);
        }
        entity.setReservationTime(dto.getReservationTime());
        return entity;
    }


    @Override
    public List<ReservationDTO> entityListToDTOList(List<ReservationEntity> reservationEntities) {
        List<ReservationDTO> dtoList = new ArrayList<>();
        if (reservationEntities == null) {
            return null;
        }
        for(ReservationEntity reservationEntity : reservationEntities){
            dtoList.add(entityToDTO(reservationEntity));
        }
        return dtoList;
    }

    @Override
    public List<ReservationEntity> dtoListTOEntityList(List<ReservationDTO> reservationDTOS) {
        List<ReservationEntity> entityList = new ArrayList<>();
        if (reservationDTOS == null) {
            return null;
        }
        for(ReservationDTO reservationDTO : reservationDTOS){
            entityList.add(dtoToEntity(reservationDTO));
        }
        return entityList;
    }

    @Override
    public ReservationEntity requestDTOToEntity(ReservationRequestDTO dto) {
        ReservationEntity entity = new ReservationEntity();
        entity.setUpdatedDate(dto.getUpdatedDate());
        entity.setId(dto.getId());
        entity.setUuid(dto.getUuid());
        entity.setCreationDate(dto.getCreationDate());
        RoomEntity roomId = roomMapper.requestDTOToEntity(dto.getRoom());
        if (roomId != null) {
            entity.setRoom(roomId);
        }
        AirplaneEntity airplaneId = airplaneMapper.requestDTOToEntity(dto.getAirplane());
        if (airplaneId != null) {
            entity.setAirplane(airplaneId);
        }
        DoctorEntity doctorId = doctorMapper.requestDTOToEntity(dto.getDoctor());
        if (doctorId != null) {
            entity.setDoctor(doctorId);
        }
        UserEntity userId = userMapper.requestDTOToEntity(dto.getUser());
        if (userId != null) {
            entity.setUser(userId);
        }
        entity.setReservationTime(dto.getReservationTime());

        return entity;
    }

    @Override
    public List<ReservationEntity> requestDtoListTOEntityList(List<ReservationRequestDTO> reservationRequestDTOS) {
        List<ReservationEntity> entityList = new ArrayList<>();
        if (reservationRequestDTOS == null) {
            return null;
        }
        for(ReservationRequestDTO reservationRequestDTO : reservationRequestDTOS){
            entityList.add(requestDTOToEntity(reservationRequestDTO));
        }
        return entityList;
    }

    @Override
    public ReservationEntity requestDtoToExistEntity(ReservationEntity entity, ReservationRequestDTO reservationRequestDTO) {
        //entity.setDate(reservationRequestDTO.getDate());
        //entity.setStatus(reservationRequestDTO.getStatus());

        return entity;
    }

    @Override
    public PageDTO<ReservationDTO> pageEntityToPageDTO(Page<ReservationEntity> reservationEntities) {
        PageDTO<ReservationDTO> pageDTO = new PageDTO<>();
        pageDTO.setTotalPages(reservationEntities.getTotalPages());
        pageDTO.setSort(reservationEntities.getSort());
        pageDTO.setSize(reservationEntities.getSize());
        pageDTO.setNumber(reservationEntities.getNumber());
        pageDTO.setHasContent(reservationEntities.hasContent());
        pageDTO.setContent(entityListToDTOList(reservationEntities.getContent()));
        pageDTO.setTotalElements(reservationEntities.getTotalElements());

        return pageDTO;
    }
}
