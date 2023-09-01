package com.tugceozcakir.healthtourismproject.mapper;

import com.tugceozcakir.healthtourismproject.database.entity.ReportEntity;
import com.tugceozcakir.healthtourismproject.model.HospitalDTO;
import com.tugceozcakir.healthtourismproject.model.PageDTO;
import com.tugceozcakir.healthtourismproject.model.ReportDTO;
import com.tugceozcakir.healthtourismproject.model.requestDTO.ReportRequestDTO;
import com.tugceozcakir.healthtourismproject.util.IBaseMapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ReportMapper implements IBaseMapper<ReportDTO, ReportEntity, ReportRequestDTO> {
    @Override
    public ReportDTO entityToDTO(ReportEntity entity) {
        ReportDTO dto = new ReportDTO();
        dto.setReport(entity.getReport());
        dto.setUuid(entity.getUuid());
        dto.setId(entity.getId());
        dto.setCreationDate(entity.getCreationDate());
        dto.setUpdatedDate(entity.getUpdatedDate());

        return dto;
    }

    @Override
    public ReportEntity dtoToEntity(ReportDTO dto) {
        ReportEntity entity = new ReportEntity();
        entity.setReport(dto.getReport());
        entity.setUuid(dto.getUuid());
        entity.setId(dto.getId());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUpdatedDate(dto.getUpdatedDate());

        return entity;
    }

    @Override
    public List<ReportDTO> entityListToDTOList(List<ReportEntity> reportEntities) {
        List<ReportDTO> dtoList = new ArrayList<>();
        if (reportEntities == null) {
            return null;
        }
        for(ReportEntity reportEntity : reportEntities){
            dtoList.add(entityToDTO(reportEntity));
        }
        return dtoList;
    }

    @Override
    public List<ReportEntity> dtoListTOEntityList(List<ReportDTO> reportDTOS) {
        List<ReportEntity> entityList = new ArrayList<>();
        if (reportDTOS == null) {
            return null;
        }
        for(ReportDTO reportDTO : reportDTOS){
            entityList.add(dtoToEntity(reportDTO));
        }
        return entityList;
    }

    @Override
    public ReportEntity requestDTOToEntity(ReportRequestDTO dto) {
        ReportEntity entity = new ReportEntity();
        entity.setReport(dto.getReport());
        entity.setUuid(dto.getUuid());
        entity.setId(dto.getId());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUpdatedDate(dto.getUpdatedDate());

        return entity;
    }

    @Override
    public List<ReportEntity> requestDtoListTOEntityList(List<ReportRequestDTO> reportRequestDTOS) {
        List<ReportEntity> entityList = new ArrayList<>();
        if (reportRequestDTOS == null) {
            return null;
        }
        for(ReportRequestDTO reportRequestDTO : reportRequestDTOS){
            entityList.add(requestDTOToEntity(reportRequestDTO));
        }
        return entityList;
    }

    @Override
    public ReportEntity requestDtoToExistEntity(ReportEntity entity, ReportRequestDTO reportRequestDTO) {
        entity.setReport(reportRequestDTO.getReport());
        return entity;
    }

    @Override
    public PageDTO<ReportDTO> pageEntityToPageDTO(Page<ReportEntity> reportEntities) {
        PageDTO<ReportDTO> pageDTO = new PageDTO<>();
        pageDTO.setTotalPages(reportEntities.getTotalPages());
        pageDTO.setSort(reportEntities.getSort());
        pageDTO.setSize(reportEntities.getSize());
        pageDTO.setNumber(reportEntities.getNumber());
        pageDTO.setHasContent(reportEntities.hasContent());
        pageDTO.setContent(entityListToDTOList(reportEntities.getContent()));
        pageDTO.setTotalElements(reportEntities.getTotalElements());

        return pageDTO;
    }
}
