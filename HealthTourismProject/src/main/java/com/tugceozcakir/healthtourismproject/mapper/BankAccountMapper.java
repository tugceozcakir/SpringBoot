package com.tugceozcakir.healthtourismproject.mapper;

import com.tugceozcakir.healthtourismproject.database.entity.BankAccountEntity;
import com.tugceozcakir.healthtourismproject.model.BankAccountDTO;
import com.tugceozcakir.healthtourismproject.model.HospitalDTO;
import com.tugceozcakir.healthtourismproject.model.PageDTO;
import com.tugceozcakir.healthtourismproject.model.requestDTO.BankAccountRequestDTO;
import com.tugceozcakir.healthtourismproject.util.BaseDTO;
import com.tugceozcakir.healthtourismproject.util.IBaseMapper;
import com.tugceozcakir.healthtourismproject.util.dbUtil.BaseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BankAccountMapper implements IBaseMapper<BankAccountDTO, BankAccountEntity, BankAccountRequestDTO> {

    @Override
    public BankAccountDTO entityToDTO(BankAccountEntity entity) {
        BankAccountDTO dto = new BankAccountDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setUuid(entity.getUuid());
        dto.setCreationDate(entity.getCreationDate());
        dto.setUpdatedDate(entity.getUpdatedDate());
        dto.setAmount(entity.getAmount());
        dto.setIban(entity.getIban());

        return dto;
    }

    @Override
    public BankAccountEntity dtoToEntity(BankAccountDTO dto) {
        BankAccountEntity entity = new BankAccountEntity();

        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setUuid(dto.getUuid());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUpdatedDate(dto.getUpdatedDate());
        entity.setAmount(dto.getAmount());
        entity.setIban(dto.getIban());

        return entity;
    }

    @Override
    public List<BankAccountDTO> entityListToDTOList(List<BankAccountEntity> bankAccountEntities) {
        List<BankAccountDTO> dtoList = new ArrayList<>();

        for(BankAccountEntity bankAccountEntity : bankAccountEntities){
            dtoList.add(entityToDTO(bankAccountEntity));
        }
        return dtoList;
    }

    @Override
    public List<BankAccountEntity> dtoListTOEntityList(List<BankAccountDTO> bankAccountDTOS) {
        List<BankAccountEntity> entityList = new ArrayList<>();

        for(BankAccountDTO bankAccountDTO : bankAccountDTOS){
            entityList.add(dtoToEntity(bankAccountDTO));
        }
        return entityList;
    }

    @Override
    public BankAccountEntity requestDTOToEntity(BankAccountRequestDTO dto) {
        BankAccountEntity entity = new BankAccountEntity();

        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setUuid(dto.getUuid());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUpdatedDate(dto.getUpdatedDate());
        entity.setAmount(dto.getAmount());
        entity.setIban(dto.getIban());

        return entity;
    }

    @Override
    public List<BankAccountEntity> requestDtoListTOEntityList(List<BankAccountRequestDTO> bankAccountRequestDTOS) {
        List<BankAccountEntity> entityList = new ArrayList<>();

        if (bankAccountRequestDTOS != null) {
            for (BankAccountRequestDTO bankAccountRequestDTO : bankAccountRequestDTOS) {
                entityList.add(requestDTOToEntity(bankAccountRequestDTO));
            }
        }
        return entityList;
    }

    @Override
    public BankAccountEntity requestDtoToExistEntity(BankAccountEntity entity, BankAccountRequestDTO bankAccountRequestDTO) {
        return null;
    }

    @Override
    public PageDTO<BankAccountDTO> pageEntityToPageDTO(Page<BankAccountEntity> bankAccountEntities) {
        PageDTO<BankAccountDTO> pageDTO = new PageDTO<>();
        pageDTO.setTotalPages(bankAccountEntities.getTotalPages());
        pageDTO.setSort(bankAccountEntities.getSort());
        pageDTO.setSize(bankAccountEntities.getSize());
        pageDTO.setNumber(bankAccountEntities.getNumber());
        pageDTO.setHasContent(bankAccountEntities.hasContent());
        pageDTO.setContent(entityListToDTOList(bankAccountEntities.getContent()));
        pageDTO.setTotalElements(bankAccountEntities.getTotalElements());

        return pageDTO;
    }
}
