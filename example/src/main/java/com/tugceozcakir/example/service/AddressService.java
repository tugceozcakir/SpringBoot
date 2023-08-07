package com.tugceozcakir.example.service;

import com.tugceozcakir.example.database.entity.AddressEntity;
import com.tugceozcakir.example.database.entity.PersonEntity;
import com.tugceozcakir.example.database.repository.AddressEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AddressService {

    @Autowired
    AddressEntityRepository addressEntityRepository;

    public AddressEntity createAddress(String address, String title){
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setAddress(address);
        addressEntity.setTitle(title);

        addressEntityRepository.save(addressEntity);
        return addressEntity;
    }

    public AddressEntity getAddresByUUID(UUID uuid) {

        Optional<AddressEntity> addressEntityOptional = addressEntityRepository.findByUuid(uuid);

        if (addressEntityOptional.isPresent()) {
            return addressEntityOptional.get();
        } else {
            return null;
        }

    }

    public List<AddressEntity> getAllAddresses() {
        return addressEntityRepository.findAll();
    }
    @Transactional
    public AddressEntity updateAddressByUUID(UUID uuid, AddressEntity newAddressEntity) {

        AddressEntity addressEntity = getAddresByUUID(uuid);

        if (addressEntity != null) {
            addressEntity.setTitle(newAddressEntity.getTitle());
            addressEntity.setAddress(newAddressEntity.getAddress());
            addressEntity.setPerson(newAddressEntity.getPerson());

            addressEntityRepository.save(addressEntity);
            return addressEntity;
        } else {
            return null;
        }


    }


    @Transactional
    public Boolean deleteAddressByUUID(UUID uuid) {
        AddressEntity addressEntity = getAddresByUUID(uuid);

        if (addressEntity != null) {
            addressEntityRepository.deleteById(addressEntity.getId());
            return true;
        } else {
            return false;
        }
    }


}
