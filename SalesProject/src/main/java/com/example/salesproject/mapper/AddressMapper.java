package com.example.salesproject.mapper;

import com.example.salesproject.database.entity.AddressEntity;
import com.example.salesproject.model.AddressDTO;
import com.example.salesproject.model.requestDTO.AddressRequestDTO;
import com.example.salesproject.util.IBaseMapper;
import org.springframework.stereotype.Component;

@Component
public interface AddressMapper extends IBaseMapper<AddressDTO, AddressEntity, AddressRequestDTO> {
}
