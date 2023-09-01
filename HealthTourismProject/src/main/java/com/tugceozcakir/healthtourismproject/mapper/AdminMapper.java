package com.tugceozcakir.healthtourismproject.mapper;

import com.tugceozcakir.healthtourismproject.database.entity.AdminEntity;
import com.tugceozcakir.healthtourismproject.model.AdminDTO;
import com.tugceozcakir.healthtourismproject.model.PageDTO;
import com.tugceozcakir.healthtourismproject.model.requestDTO.AdminRequestDTO;
import com.tugceozcakir.healthtourismproject.util.IBaseMapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AdminMapper implements IBaseMapper<AdminDTO, AdminEntity, AdminRequestDTO> {
    @Override
    public AdminDTO entityToDTO(AdminEntity entity) {
        AdminDTO dto = new AdminDTO();
        dto.setEmail(entity.getEmail());
        dto.setPassword(entity.getPassword());
        dto.setUuid(entity.getUuid());
        dto.setId(entity.getId());
        dto.setCreationDate(entity.getCreationDate());
        dto.setUpdatedDate(entity.getUpdatedDate());

        return dto;
    }

    @Override
    public AdminEntity dtoToEntity(AdminDTO dto) {
        AdminEntity entity = new AdminEntity();
        entity.setEmail(dto.getEmail());
        entity.setPassword(dto.getPassword());
        entity.setUuid(dto.getUuid());
        entity.setId(dto.getId());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUpdatedDate(dto.getUpdatedDate());

        return entity;
    }

    @Override
    public List<AdminDTO> entityListToDTOList(List<AdminEntity> adminEntities) {
        List<AdminDTO> dtoList = new ArrayList<>();

        for(AdminEntity adminEntity: adminEntities){
            dtoList.add(entityToDTO(adminEntity));
        }
        return dtoList;
    }

    @Override
    public List<AdminEntity> dtoListTOEntityList(List<AdminDTO> adminDTOS) {
        List<AdminEntity> entityList = new ArrayList<>();

        for(AdminDTO adminDTO: adminDTOS){
            entityList.add(dtoToEntity(adminDTO));
        }
        return entityList;
    }

    @Override
    public AdminEntity requestDTOToEntity(AdminRequestDTO dto) {
        AdminEntity adminEntity = new AdminEntity();
        adminEntity.setPassword(dto.getPassword());
        adminEntity.setEmail(dto.getEmail());
        adminEntity.setUuid(dto.getUuid());
        adminEntity.setId(dto.getId());
        adminEntity.setCreationDate(dto.getCreationDate());
        adminEntity.setUpdatedDate(dto.getUpdatedDate());

        return adminEntity;
    }

    @Override
    public List<AdminEntity> requestDtoListTOEntityList(List<AdminRequestDTO> adminRequestDTOS) {
        List<AdminEntity> adminEntities = new ArrayList<>();
        for (AdminRequestDTO requestDTO : adminRequestDTOS)
            adminEntities.add(requestDTOToEntity(requestDTO));
        return adminEntities;
    }

    @Override
    public AdminEntity requestDtoToExistEntity(AdminEntity entity, AdminRequestDTO adminRequestDTO) {
        entity.setEmail(adminRequestDTO.getEmail());
        entity.setPassword(adminRequestDTO.getPassword());

        return entity;
    }

    @Override
    public PageDTO<AdminDTO> pageEntityToPageDTO(Page<AdminEntity> adminEntities) {
        PageDTO<AdminDTO> dtoPage = new PageDTO<>();
        dtoPage.setTotalPages(adminEntities.getTotalPages());
        dtoPage.setTotalElements(adminEntities.getTotalElements());
        dtoPage.setSort(adminEntities.getSort());
        dtoPage.setSize(adminEntities.getSize());
        dtoPage.setNumber(adminEntities.getNumber());
        dtoPage.setContent(entityListToDTOList(adminEntities.getContent()));
        dtoPage.setHasContent(adminEntities.hasContent());

        return dtoPage;
    }
}
