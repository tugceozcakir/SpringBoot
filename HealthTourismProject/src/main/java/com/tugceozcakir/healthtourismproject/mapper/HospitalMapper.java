package com.tugceozcakir.healthtourismproject.mapper;

import com.tugceozcakir.healthtourismproject.database.entity.DoctorEntity;
import com.tugceozcakir.healthtourismproject.database.entity.HospitalEntity;
import com.tugceozcakir.healthtourismproject.database.entity.ReservationEntity;
import com.tugceozcakir.healthtourismproject.model.DoctorDTO;
import com.tugceozcakir.healthtourismproject.model.HospitalDTO;
import com.tugceozcakir.healthtourismproject.model.PageDTO;
import com.tugceozcakir.healthtourismproject.model.requestDTO.HospitalRequestDTO;
import com.tugceozcakir.healthtourismproject.util.IBaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class HospitalMapper implements IBaseMapper<HospitalDTO, HospitalEntity, HospitalRequestDTO> {

    @Autowired
    DoctorMapper doctorMapper;

    @Override
    public HospitalDTO entityToDTO(HospitalEntity entity) {
        HospitalDTO dto = new HospitalDTO();
        dto.setContactNumber(entity.getContactNumber());
        dto.setCity(entity.getCity());
        dto.setName(entity.getName());
        dto.setAddress(entity.getAddress());
        dto.setUuid(entity.getUuid());
        dto.setId(entity.getId());
        dto.setCreationDate(entity.getCreationDate());
        dto.setUpdatedDate(entity.getUpdatedDate());
        List<DoctorDTO> doctorId = doctorMapper.entityListToDTOList(entity.getDoctors());
        if (doctorId != null) {
            dto.setDoctors(doctorId);
        }
        return dto;
    }

    @Override
    public HospitalEntity dtoToEntity(HospitalDTO dto) {
        HospitalEntity entity = new HospitalEntity();
        entity.setContactNumber(dto.getContactNumber());
        entity.setCity(dto.getCity());
        entity.setName(dto.getName());
        entity.setAddress(dto.getAddress());
        entity.setUuid(dto.getUuid());
        entity.setId(dto.getId());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUpdatedDate(dto.getUpdatedDate());
        List<DoctorEntity> doctorId = doctorMapper.dtoListTOEntityList(dto.getDoctors());
        if (doctorId != null) {
            entity.setDoctors(doctorId);
        }
        return entity;
    }

    @Override
    public List<HospitalDTO> entityListToDTOList(List<HospitalEntity> hospitalEntities) {
        List<HospitalDTO> dtoList = new ArrayList<>();
        if (hospitalEntities == null) {
            return null;
        }
        for(HospitalEntity hospitalEntity : hospitalEntities){
            dtoList.add(entityToDTO(hospitalEntity));
        }
        return dtoList;
    }

    @Override
    public List<HospitalEntity> dtoListTOEntityList(List<HospitalDTO> hospitalDTOS) {
        List<HospitalEntity> entityList = new ArrayList<>();
        if (hospitalDTOS == null) {
            return null;
        }
        for(HospitalDTO hospitalDTO : hospitalDTOS){
            entityList.add(dtoToEntity(hospitalDTO));
        }
        return entityList;
    }

    @Override
    public HospitalEntity requestDTOToEntity(HospitalRequestDTO dto) {
        HospitalEntity entity = new HospitalEntity();
        entity.setContactNumber(dto.getContactNumber());
        entity.setCity(dto.getCity());
        entity.setName(dto.getName());
        entity.setAddress(dto.getAddress());
        entity.setUuid(dto.getUuid());
        entity.setId(dto.getId());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUpdatedDate(dto.getUpdatedDate());
        List<DoctorEntity> doctorId = doctorMapper.requestDtoListTOEntityList(dto.getDoctors());
        if (doctorId != null) {
            entity.setDoctors(doctorId);
        }

        return entity;
    }

    @Override
    public List<HospitalEntity> requestDtoListTOEntityList(List<HospitalRequestDTO> hospitalRequestDTOS) {
        List<HospitalEntity> entityList = new ArrayList<>();
        if (hospitalRequestDTOS == null) {
            return null;
        }
        for(HospitalRequestDTO hospitalRequestDTO : hospitalRequestDTOS){
            entityList.add(requestDTOToEntity(hospitalRequestDTO));
        }
        return entityList;
    }

    @Override
    public HospitalEntity requestDtoToExistEntity(HospitalEntity entity, HospitalRequestDTO hospitalRequestDTO) {
        entity.setContactNumber(hospitalRequestDTO.getContactNumber());
        entity.setCity(hospitalRequestDTO.getCity());
        entity.setName(hospitalRequestDTO.getName());
        entity.setAddress(hospitalRequestDTO.getAddress());
        List<DoctorEntity> doctorId = doctorMapper.requestDtoListTOEntityList(hospitalRequestDTO.getDoctors());
        if (doctorId != null) {
            entity.setDoctors(doctorId);
        }
        return entity;
    }

    @Override
    public PageDTO<HospitalDTO> pageEntityToPageDTO(Page<HospitalEntity> hospitalEntities) {
        PageDTO<HospitalDTO> pageDTO = new PageDTO<>();
        pageDTO.setTotalPages(hospitalEntities.getTotalPages());
        pageDTO.setSort(hospitalEntities.getSort());
        pageDTO.setSize(hospitalEntities.getSize());
        pageDTO.setNumber(hospitalEntities.getNumber());
        pageDTO.setHasContent(hospitalEntities.hasContent());
        pageDTO.setContent(entityListToDTOList(hospitalEntities.getContent()));
        pageDTO.setTotalElements(hospitalEntities.getTotalElements());

        return pageDTO;
    }
}
