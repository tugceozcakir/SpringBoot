package com.example.salesproject.util;

import com.example.salesproject.util.dbutil.BaseEntity;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@NoRepositoryBean
public abstract class BaseService<DTO extends BaseDTO,
        Entity extends BaseEntity,
        RequestDTO extends BaseDTO,
        Mapper extends IBaseMapper<DTO, Entity, RequestDTO>,
        Repository extends BaseRepository>
{
    public abstract Mapper getMapper();
    public abstract Repository getRepository();

    public DTO save(RequestDTO requestDTO){
        Entity entity = getMapper().requestDTOToEntity(requestDTO);
        getRepository().save(entity);
        return getMapper().entityToDTO(entity);
    }

    public DTO update(UUID uuid, RequestDTO requestDTO){
        Optional<Entity> entity = getRepository().findByUuid(uuid);
        if(entity.isPresent()){
            Entity newEntity = getMapper().requestDTOToEntity(requestDTO);
            getRepository().save(newEntity);
            return getMapper().entityToDTO(newEntity);
        } else{
            return null;
        }
    }

    public Boolean deleteByUuid(UUID uuid){
        Optional<Entity> entity = getRepository().findByUuid(uuid);
        if(entity.isPresent()){
            getRepository().delete(entity);
            return true;
        }else{
            return false;
        }
    }

    public List<DTO> getAll(){
        return getMapper().entityListToDTOList(getRepository().findAll());
    }
}