package com.tugceozcakir.healthtourismproject.mapper;

import com.tugceozcakir.healthtourismproject.database.entity.DoctorEntity;
import com.tugceozcakir.healthtourismproject.database.entity.ReportEntity;
import com.tugceozcakir.healthtourismproject.database.entity.ReservationEntity;
import com.tugceozcakir.healthtourismproject.model.*;
import com.tugceozcakir.healthtourismproject.model.requestDTO.DoctorRequestDTO;
import com.tugceozcakir.healthtourismproject.util.IBaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import javax.swing.text.html.parser.Entity;
import java.util.ArrayList;
import java.util.List;

@Component
public class DoctorMapper implements IBaseMapper<DoctorDTO, DoctorEntity, DoctorRequestDTO> {

    @Lazy
    @Autowired
    ReservationMapper reservationMapper;

    @Autowired
    AvailabilityMapper availabilityMapper;

    @Autowired
    ReportMapper reportMapper;

    @Override
    public DoctorDTO entityToDTO(DoctorEntity entity) {
        DoctorDTO dto = new DoctorDTO();
        dto.setName(entity.getName());
        dto.setEmail(entity.getEmail());
        dto.setPassword(entity.getPassword());
        dto.setSurname(entity.getSurname());
        dto.setAppointmentTime(availabilityMapper.entityListToDTOList(entity.getAppointmentTime()));
        dto.setInspectionTimes(entity.getInspectionTimes());
        dto.setUuid(entity.getUuid());
        dto.setId(entity.getId());
        dto.setCreationDate(entity.getCreationDate());
        dto.setUpdatedDate(entity.getUpdatedDate());
        dto.setDoctorFee(entity.getDoctorFee());
        List<ReportDTO> reportId = reportMapper.entityListToDTOList(entity.getDoctorReports());
        if (reportId != null) {
            dto.setReports(reportId);
        }
        return dto;
    }

    @Override
    public DoctorEntity dtoToEntity(DoctorDTO dto) {
        DoctorEntity entity = new DoctorEntity();
        entity.setName(dto.getName());
        entity.setEmail(dto.getEmail());
        entity.setPassword(dto.getPassword());
        entity.setSurname(dto.getSurname());
        //entity.setWorkingHospital(hospitalMapper.dtoToEntity(dto.getWorkingHospital()));
        entity.setAppointmentTime(availabilityMapper.dtoListTOEntityList(dto.getAppointmentTime()));
        entity.setInspectionTimes(dto.getInspectionTimes());
        entity.setUuid(dto.getUuid());
        entity.setId(dto.getId());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUpdatedDate(dto.getUpdatedDate());
        entity.setDoctorFee(dto.getDoctorFee());
        List<ReportEntity> reportId = reportMapper.dtoListTOEntityList(dto.getReports());
        if (reportId != null) {
            entity.setDoctorReports(reportId);
        }

        return entity;
    }

    @Override
    public List<DoctorDTO> entityListToDTOList(List<DoctorEntity> doctorEntities) {
        List<DoctorDTO> dtoList = new ArrayList<>();
        if (doctorEntities == null) {
            return null;
        }
        for(DoctorEntity doctorEntity : doctorEntities){
            dtoList.add(entityToDTO(doctorEntity));
        }

        return dtoList;
    }

    @Override
    public List<DoctorEntity> dtoListTOEntityList(List<DoctorDTO> doctorDTOS) {
        List<DoctorEntity> doctorEntityList = new ArrayList<>();
        if (doctorDTOS == null) {
            return null;
        }
        for(DoctorDTO doctorDTO : doctorDTOS){
            doctorEntityList.add(dtoToEntity(doctorDTO));
        }
        return doctorEntityList;
    }

    @Override
    public DoctorEntity requestDTOToEntity(DoctorRequestDTO dto) {
        DoctorEntity entity = new DoctorEntity();
        entity.setName(dto.getName());
        entity.setEmail(dto.getEmail());
        entity.setPassword(dto.getPassword());
        entity.setSurname(dto.getSurname());
        //entity.setWorkingHospital(hospitalMapper.requestDTOToEntity(dto.getWorkingHospital()));
        entity.setAppointmentTime(availabilityMapper.requestDtoListTOEntityList(dto.getAppointmentTime()));
        entity.setInspectionTimes(dto.getInspectionTimes());
        entity.setUuid(dto.getUuid());
        entity.setId(dto.getId());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUpdatedDate(dto.getUpdatedDate());
        entity.setDoctorFee(dto.getDoctorFee());
        List<ReportEntity> reportId = reportMapper.requestDtoListTOEntityList(dto.getReports());
        if (reportId != null) {
            entity.setDoctorReports(reportId);
        }
        return entity;
    }

    @Override
    public List<DoctorEntity> requestDtoListTOEntityList(List<DoctorRequestDTO> doctorRequestDTOS) {
        List<DoctorEntity> doctorEntityList = new ArrayList<>();
        if (doctorRequestDTOS == null) {
            return null;
        }
        for (DoctorRequestDTO doctorRequestDTO : doctorRequestDTOS){
            doctorEntityList.add(requestDTOToEntity(doctorRequestDTO));
        }
        return doctorEntityList;
    }

    @Override
    public DoctorEntity requestDtoToExistEntity(DoctorEntity entity, DoctorRequestDTO doctorRequestDTO) {
        entity.setName(doctorRequestDTO.getName());
        entity.setEmail(doctorRequestDTO.getEmail());
        entity.setPassword(doctorRequestDTO.getPassword());
        entity.setSurname(doctorRequestDTO.getSurname());
        entity.setDoctorFee(doctorRequestDTO.getDoctorFee());
        entity.setAppointmentTime(availabilityMapper.requestDtoListTOEntityList(doctorRequestDTO.getAppointmentTime()));
        entity.setInspectionTimes(doctorRequestDTO.getInspectionTimes());
        List<ReportEntity> reportId = reportMapper.requestDtoListTOEntityList(doctorRequestDTO.getReports());
        if (reportId != null) {
            entity.setDoctorReports(reportId);
        }
        return entity;
    }

    @Override
    public PageDTO<DoctorDTO> pageEntityToPageDTO(Page<DoctorEntity> doctorEntities) {
        PageDTO<DoctorDTO> pageDTO = new PageDTO<>();
        pageDTO.setTotalPages(doctorEntities.getTotalPages());
        pageDTO.setSort(doctorEntities.getSort());
        pageDTO.setSize(doctorEntities.getSize());
        pageDTO.setNumber(doctorEntities.getNumber());
        pageDTO.setHasContent(doctorEntities.hasContent());
        pageDTO.setContent(entityListToDTOList(doctorEntities.getContent()));
        pageDTO.setTotalElements(doctorEntities.getTotalElements());

        return pageDTO;
    }
}
