package com.tugceozcakir.healthtourismproject.mapper;

import com.tugceozcakir.healthtourismproject.database.entity.BankAccountEntity;
import com.tugceozcakir.healthtourismproject.database.entity.UserEntity;
import com.tugceozcakir.healthtourismproject.model.BankAccountDTO;
import com.tugceozcakir.healthtourismproject.model.PageDTO;
import com.tugceozcakir.healthtourismproject.model.ReportDTO;
import com.tugceozcakir.healthtourismproject.model.UserDTO;
import com.tugceozcakir.healthtourismproject.model.requestDTO.UserRequestDTO;
import com.tugceozcakir.healthtourismproject.util.IBaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserMapper implements IBaseMapper<UserDTO, UserEntity, UserRequestDTO> {

    @Autowired
    BankAccountMapper bankAccountMapper;

    @Override
    public UserDTO entityToDTO(UserEntity entity) {
        UserDTO dto = new UserDTO();
        dto.setBirthday(entity.getBirthday());
        dto.setSex(entity.getSex());
        dto.setName(entity.getName());
        dto.setPassword(entity.getPassword());
        dto.setSurname(entity.getSurname());
        dto.setMobileNumber(entity.getMobileNumber());
        dto.setEmail(entity.getEmail());
        dto.setId(entity.getId());
        dto.setUuid(entity.getUuid());
        List<BankAccountDTO> bankAccountId = bankAccountMapper.entityListToDTOList(entity.getBankAccounts());
        if (bankAccountId != null) {
            dto.setBankAccounts(bankAccountId);
        }

        return dto;
    }

    @Override
    public UserEntity dtoToEntity(UserDTO dto) {
        UserEntity entity = new UserEntity();
        entity.setBirthday(dto.getBirthday());
        entity.setSex(dto.getSex());
        entity.setName(dto.getName());
        entity.setPassword(dto.getPassword());
        entity.setSurname(dto.getSurname());
        entity.setMobileNumber(dto.getMobileNumber());
        entity.setEmail(dto.getEmail());
        entity.setId(dto.getId());
        entity.setUuid(dto.getUuid());
        List<BankAccountEntity> bankAccountId = bankAccountMapper.dtoListTOEntityList(dto.getBankAccounts());
        if (bankAccountId != null) {
            entity.setBankAccounts(bankAccountId);
        }

        return entity;
    }

    @Override
    public List<UserDTO> entityListToDTOList(List<UserEntity> userEntities) {
        List<UserDTO> dtoList = new ArrayList<>();

        for (UserEntity userEntity : userEntities){
            dtoList.add(entityToDTO(userEntity));
        }
        return dtoList;
    }

    @Override
    public List<UserEntity> dtoListTOEntityList(List<UserDTO> userDTOS) {
        List<UserEntity> entityList = new ArrayList<>();

        for(UserDTO userDTO : userDTOS){
            entityList.add(dtoToEntity(userDTO));
        }
        return entityList;
    }

    @Override
    public UserEntity requestDTOToEntity(UserRequestDTO dto) {
        UserEntity entity = new UserEntity();
        entity.setBirthday(dto.getBirthday());
        entity.setSex(dto.getSex());
        entity.setName(dto.getName());
        entity.setPassword(dto.getPassword());
        entity.setSurname(dto.getSurname());
        entity.setMobileNumber(dto.getMobileNumber());
        entity.setEmail(dto.getEmail());
        entity.setId(dto.getId());
        entity.setUuid(dto.getUuid());

        List<BankAccountEntity> bankAccountId = bankAccountMapper.requestDtoListTOEntityList(dto.getBankAccounts());
        if (bankAccountId != null) {
            entity.setBankAccounts(bankAccountId);
        }

        return entity;
    }

    @Override
    public List<UserEntity> requestDtoListTOEntityList(List<UserRequestDTO> userRequestDTOS) {
        List<UserEntity> entityList = new ArrayList<>();

        for(UserRequestDTO userRequestDTO : userRequestDTOS){
            entityList.add(requestDTOToEntity(userRequestDTO));
        }
        return entityList;
    }

    @Override
    public UserEntity requestDtoToExistEntity(UserEntity entity, UserRequestDTO userRequestDTO) {
        entity.setBirthday(userRequestDTO.getBirthday());
        entity.setSex(userRequestDTO.getSex());
        entity.setName(userRequestDTO.getName());
        entity.setPassword(userRequestDTO.getPassword());
        entity.setSurname(userRequestDTO.getSurname());
        entity.setMobileNumber(userRequestDTO.getMobileNumber());
        entity.setEmail(userRequestDTO.getEmail());

        List<BankAccountEntity> bankAccountId = bankAccountMapper.requestDtoListTOEntityList(userRequestDTO.getBankAccounts());
        if (bankAccountId != null) {
            entity.setBankAccounts(bankAccountId);
        }

        return entity;
    }

    @Override
    public PageDTO<UserDTO> pageEntityToPageDTO(Page<UserEntity> userEntities) {
        PageDTO<UserDTO> pageDTO = new PageDTO<>();
        pageDTO.setTotalPages(userEntities.getTotalPages());
        pageDTO.setSort(userEntities.getSort());
        pageDTO.setSize(userEntities.getSize());
        pageDTO.setNumber(userEntities.getNumber());
        pageDTO.setHasContent(userEntities.hasContent());
        pageDTO.setContent(entityListToDTOList(userEntities.getContent()));
        pageDTO.setTotalElements(userEntities.getTotalElements());

        return pageDTO;
    }
}
