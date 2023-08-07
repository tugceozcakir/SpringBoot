package com.tugceozcakir.example.controller;

import com.tugceozcakir.example.database.entity.AddressEntity;
import com.tugceozcakir.example.database.entity.PersonEntity;
import com.tugceozcakir.example.mapper.AddressMapper;
import com.tugceozcakir.example.model.AddressDTO;
import com.tugceozcakir.example.service.AddressService;
import com.tugceozcakir.example.service.PersonService;
import com.tugceozcakir.example.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/address")
public class AddressController extends BaseController<AddressDTO, AddressEntity> {

    @Autowired
    AddressService addressService;

    @Autowired
    AddressMapper addressMapper;

    @Autowired
    PersonService personService;

    @Override
    public ResponseEntity<List<AddressDTO>> getAll() {
        List<AddressEntity> addressEntityList = addressService.getAllAddresses();
        List<AddressDTO> addressDTOList = addressMapper.entityListToDTOList(addressEntityList);
        return new ResponseEntity<>(addressDTOList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<AddressEntity> getById(UUID id) {
        AddressEntity addressEntity = addressService.getAddresByUUID(id);
        if (addressEntity != null) {
            return new ResponseEntity<>(addressEntity, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<AddressEntity> create(AddressDTO addressDTO) {
        try {
            AddressEntity addressEntity = addressService.createAddress(
                    addressDTO.getAddress(), addressDTO.getTitle());

            return new ResponseEntity<>(addressEntity, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @Override
    public ResponseEntity<AddressEntity> update(UUID id, AddressEntity addressEntity) {
        AddressEntity updatedAddress = addressService.updateAddressByUUID(id, addressEntity);
        if (updatedAddress != null) {
            return new ResponseEntity<>(updatedAddress, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<Boolean> delete(UUID id) {
        Boolean isDeleted = addressService.deleteAddressByUUID(id);
        if (isDeleted) {
            return new ResponseEntity<>(Boolean.TRUE, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(Boolean.FALSE, HttpStatus.NOT_FOUND);
        }
    }
}

