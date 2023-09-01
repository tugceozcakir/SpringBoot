package com.tugceozcakir.healthtourismproject.mapper;

import com.tugceozcakir.healthtourismproject.database.entity.AirplaneEntity;
import com.tugceozcakir.healthtourismproject.database.entity.AvailabilityEntity;
import com.tugceozcakir.healthtourismproject.database.entity.ReservationEntity;
import com.tugceozcakir.healthtourismproject.model.AirplaneDTO;
import com.tugceozcakir.healthtourismproject.model.AvailabilityDTO;
import com.tugceozcakir.healthtourismproject.model.PageDTO;
import com.tugceozcakir.healthtourismproject.model.ReservationDTO;
import com.tugceozcakir.healthtourismproject.model.requestDTO.AirplaneRequestDTO;
import com.tugceozcakir.healthtourismproject.util.IBaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AirplaneMapper implements IBaseMapper<AirplaneDTO, AirplaneEntity, AirplaneRequestDTO> {

    @Lazy
    @Autowired
    ReservationMapper reservationMapper;

    @Autowired
    AvailabilityMapper availabilityMapper;

    @Override
    public AirplaneDTO entityToDTO(AirplaneEntity entity) {
        AirplaneDTO airplaneDTO = new AirplaneDTO();
        airplaneDTO.setDestination(entity.getDestination());
        airplaneDTO.setClassName(entity.getClassName());
        airplaneDTO.setEmptySeatCount(entity.getEmptySeatCount());
        airplaneDTO.setDepartureLocation(entity.getDepartureLocation());
        airplaneDTO.setTotalSeatingCapacity(entity.getTotalSeatingCapacity());
        airplaneDTO.setUuid(entity.getUuid());
        airplaneDTO.setId(entity.getId());
        airplaneDTO.setCreationDate(entity.getCreationDate());
        airplaneDTO.setUpdatedDate(entity.getUpdatedDate());
        airplaneDTO.setAirplaneTicketPrice(entity.getAirplaneTicketPrice());
        List<AvailabilityDTO> flightTimeIds = availabilityMapper.entityListToDTOList(entity.getFlightTime());
        if (flightTimeIds != null) {
            airplaneDTO.setFlightTime(flightTimeIds);
        }
        airplaneDTO.setDepartureDate(entity.getDepartureDate());
        /*List<ReservationDTO> reservationId = reservationMapper.entityListToDTOList(entity.getReservations());
        if (reservationId != null) {
            airplaneDTO.setReservations(reservationId);
        }

         */


        return airplaneDTO;
    }

    @Override
    public AirplaneEntity dtoToEntity(AirplaneDTO dto) {
        AirplaneEntity entity = new AirplaneEntity();
        entity.setDestination(dto.getDestination());
        entity.setClassName(dto.getClassName());
        entity.setEmptySeatCount(dto.getEmptySeatCount());
        entity.setDepartureLocation(dto.getDepartureLocation());
        entity.setTotalSeatingCapacity(dto.getTotalSeatingCapacity());
        entity.setUuid(dto.getUuid());
        entity.setId(dto.getId());
        entity.setAirplaneTicketPrice(dto.getAirplaneTicketPrice());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUpdatedDate(dto.getUpdatedDate());
        entity.setDepartureDate(dto.getDepartureDate());
        List<AvailabilityEntity> flightTimeIds = availabilityMapper.dtoListTOEntityList(dto.getFlightTime());
        if (flightTimeIds != null) {
            entity.setFlightTime(flightTimeIds);
        }
        /*List<ReservationEntity> reservationId = reservationMapper.dtoListTOEntityList(dto.getReservations());
        if (reservationId != null) {
            entity.setReservations(reservationId);
        }

         */
        return entity;
    }

    @Override
    public List<AirplaneDTO> entityListToDTOList(List<AirplaneEntity> airplaneEntities) {
        List<AirplaneDTO> airplaneDTOList = new ArrayList<>();
        if (airplaneEntities == null) {
            return null;
        }
        for(AirplaneEntity airplaneEntity : airplaneEntities){
            airplaneDTOList.add(entityToDTO(airplaneEntity));
        }
        return airplaneDTOList;
    }

    @Override
    public List<AirplaneEntity> dtoListTOEntityList(List<AirplaneDTO> airplaneDTOS) {
        List<AirplaneEntity> airplaneEntityList = new ArrayList<>();
        if (airplaneDTOS == null) {
            return null;
        }
        for(AirplaneDTO airplaneDTO : airplaneDTOS){
            airplaneEntityList.add(dtoToEntity(airplaneDTO));
        }
        return airplaneEntityList;
    }

    @Override
    public AirplaneEntity requestDTOToEntity(AirplaneRequestDTO dto) {
        AirplaneEntity entity = new AirplaneEntity();
        entity.setDestination(dto.getDestination());
        entity.setClassName(dto.getClassName());
        entity.setEmptySeatCount(dto.getEmptySeatCount());
        entity.setDepartureLocation(dto.getDepartureLocation());
        entity.setTotalSeatingCapacity(dto.getTotalSeatingCapacity());
        entity.setAirplaneTicketPrice(dto.getAirplaneTicketPrice());
        entity.setUuid(dto.getUuid());
        entity.setId(dto.getId());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUpdatedDate(dto.getUpdatedDate());
        entity.setDepartureDate(dto.getDepartureDate());
        List<AvailabilityEntity> flightTimeIds = availabilityMapper.requestDtoListTOEntityList(dto.getFlightTime());
        if (flightTimeIds != null) {
            entity.setFlightTime(flightTimeIds);
        }
        /*List<ReservationEntity> reservationId = reservationMapper.requestDtoListTOEntityList(dto.getReservations());
        if (reservationId != null) {
            entity.setReservations(reservationId);
        }

         */
        return entity;
    }

    @Override
    public List<AirplaneEntity> requestDtoListTOEntityList(List<AirplaneRequestDTO> airplaneRequestDTOS) {
        List<AirplaneEntity> entityList = new ArrayList<>();
        if (airplaneRequestDTOS == null) {
            return null;
        }
        for(AirplaneRequestDTO airplaneRequestDTO : airplaneRequestDTOS){
            entityList.add(requestDTOToEntity(airplaneRequestDTO));
        }
        return entityList;
    }

    @Override
    public AirplaneEntity requestDtoToExistEntity(AirplaneEntity entity, AirplaneRequestDTO airplaneRequestDTO) {
        entity.setDestination(airplaneRequestDTO.getDestination());
        entity.setClassName(airplaneRequestDTO.getClassName());
        entity.setEmptySeatCount(airplaneRequestDTO.getEmptySeatCount());
        entity.setDepartureLocation(airplaneRequestDTO.getDepartureLocation());
        entity.setTotalSeatingCapacity(airplaneRequestDTO.getTotalSeatingCapacity());
        List<AvailabilityEntity> flightTimeIds = availabilityMapper.requestDtoListTOEntityList(airplaneRequestDTO.getFlightTime());
        entity.setDepartureDate(airplaneRequestDTO.getDepartureDate());
        if (flightTimeIds != null) {
            entity.setFlightTime(flightTimeIds);
        }
        return entity;
    }

    @Override
    public PageDTO<AirplaneDTO> pageEntityToPageDTO(Page<AirplaneEntity> airplaneEntities) {
        PageDTO<AirplaneDTO> pageDTO = new PageDTO<>();
        pageDTO.setTotalPages(airplaneEntities.getTotalPages());
        pageDTO.setSort(airplaneEntities.getSort());
        pageDTO.setSize(airplaneEntities.getSize());
        pageDTO.setNumber(airplaneEntities.getNumber());
        pageDTO.setHasContent(airplaneEntities.hasContent());
        pageDTO.setContent(entityListToDTOList(airplaneEntities.getContent()));
        pageDTO.setTotalElements(airplaneEntities.getTotalElements());

        return pageDTO;
    }
}
