package com.allianz.example.service;

import com.allianz.example.database.entity.AddressEntity;
import com.allianz.example.database.entity.ProductEntity;
import com.allianz.example.database.repository.AddressEntityRepository;
import com.allianz.example.database.repository.ProductEntityRepository;
import com.allianz.example.mapper.AddressMapper;
import com.allianz.example.mapper.ProductMapper;
import com.allianz.example.model.AddressDTO;
import com.allianz.example.model.BillDTO;
import com.allianz.example.model.ProductDTO;
import com.allianz.example.model.requestDTO.AddressRequestDTO;
import com.allianz.example.model.requestDTO.BillRequestDTO;
import com.allianz.example.model.requestDTO.ProductRequestDTO;
import com.allianz.example.util.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AddressService extends BaseService<AddressDTO, AddressEntity, AddressRequestDTO> {

    @Autowired
    AddressEntityRepository addressEntityRepository;

    @Autowired
    AddressMapper addressMapper;

    @Override
    public AddressDTO save(AddressRequestDTO addressRequestDTO) {
        AddressEntity address = addressMapper.requestDTOToEntity(addressRequestDTO);
        addressEntityRepository.save(address);
        return addressMapper.entityToDTO(address);
    }

    @Override
    public List<AddressDTO> getAll() {
        List<AddressEntity> addressEntities = addressEntityRepository.findAll();
        return addressMapper.entityListToDTOList(addressEntities);
    }

    @Override
    public AddressDTO update(UUID uuid, AddressRequestDTO addressRequestDTO) {
        AddressEntity address = addressEntityRepository.findByUuid(uuid).orElse(null);
        if (address == null) {
            return null;
        }
        return addressMapper.entityToDTO(addressEntityRepository.save(addressMapper.requestDtoToExistEntity(
                addressRequestDTO, address)));
    }

    @Override
    public Boolean delete(UUID uuid) {
        AddressEntity addressEntity = addressEntityRepository.findByUuid(uuid).orElse(null);
        if (addressEntity == null) {
            return false;
        }
        addressEntityRepository.delete(addressEntity);
        return true;
    }

    @Override
    public AddressDTO getSettingByUuid(UUID uuid) {
        AddressEntity addressEntity = addressEntityRepository.findByUuid(uuid).orElse(null);
        if (addressEntity == null) {
            return null;
        }
        return addressMapper.entityToDTO(addressEntity);
    }



}
