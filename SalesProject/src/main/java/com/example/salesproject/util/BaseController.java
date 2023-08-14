package com.example.salesproject.util;

import com.example.salesproject.util.dbutil.BaseEntity;
import org.apache.catalina.mapper.Mapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

public abstract class BaseController <Entity extends BaseEntity,
        DTO extends BaseDTO,
        RequestDTO extends BaseDTO,
        Service extends BaseService<DTO, Entity, RequestDTO,
                IBaseMapper<DTO, Entity, RequestDTO>,
                BaseRepository<Entity>>>

{
    protected abstract Service getBaseService();

    @GetMapping
    public ResponseEntity<List<DTO>> getAll(){
        return new ResponseEntity<>(getBaseService().getAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<DTO> save(@RequestBody RequestDTO requestDTO){
        return new ResponseEntity<>(getBaseService().save(requestDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{uuid}")
    public ResponseEntity<DTO> update(UUID uuid, @RequestBody RequestDTO requestDTO){
        return new ResponseEntity<>(getBaseService().update(uuid, requestDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{uuid}")
    public ResponseEntity<Boolean> deleteByUuid(@PathVariable UUID uuid) {
        Boolean isDeleted = getBaseService().deleteByUuid(uuid);
        if (isDeleted) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
        }
    }
}
