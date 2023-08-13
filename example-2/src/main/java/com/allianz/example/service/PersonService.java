package com.allianz.example.service;

import com.allianz.example.database.entity.PersonEntity;
import com.allianz.example.database.entity.ProductEntity;
import com.allianz.example.database.repository.PersonEntityRepository;
import com.allianz.example.database.repository.ProductEntityRepository;
import com.allianz.example.mapper.PersonMapper;
import com.allianz.example.mapper.ProductMapper;
import com.allianz.example.model.PersonDTO;
import com.allianz.example.model.ProductDTO;
import com.allianz.example.model.requestDTO.PersonRequestDTO;
import com.allianz.example.model.requestDTO.ProductRequestDTO;
import com.allianz.example.util.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

//bean
@Service
public class PersonService extends BaseService<PersonDTO, PersonEntity, PersonRequestDTO> {

    @Autowired
    PersonEntityRepository personEntityRepository;
    @Autowired
    PersonMapper personMapper;

    @Override
    public PersonDTO save(PersonRequestDTO personRequestDTO) {
        PersonEntity person = personMapper.requestDTOToEntity(personRequestDTO);
        personEntityRepository.save(person);
        return personMapper.entityToDTO(person);
    }

    @Override
    public List<PersonDTO> getAll() {
        List<PersonEntity> personEntities = personEntityRepository.findAll();
        return personMapper.entityListToDTOList(personEntities);
    }

    @Override
    public PersonDTO update(UUID uuid, PersonRequestDTO personRequestDTO) {
        PersonEntity person = personEntityRepository.findByUuid(uuid).orElse(null);
        if (person == null) {
            return null;
        }
        return personMapper.entityToDTO(personEntityRepository.save(personMapper.requestDtoToExistEntity(
                personRequestDTO, person)));
    }

    @Override
    public Boolean delete(UUID uuid) {
        PersonEntity personEntity = personEntityRepository.findByUuid(uuid).orElse(null);
        if (personEntity == null) {
            return false;
        }
        personEntityRepository.delete(personEntity);
        return true;
    }

    @Override
    public PersonDTO getSettingByUuid(UUID uuid) {
        PersonEntity personEntity = personEntityRepository.findByUuid(uuid).orElse(null);
        if (personEntity == null) {
            return null;
        }
        return personMapper.entityToDTO(personEntity);
    }




}
