package com.allianz.example.service;

import com.allianz.example.database.entity.AddressEntity;
import com.allianz.example.database.entity.TaxEntity;
import com.allianz.example.database.repository.TaxEntityRepository;
import com.allianz.example.mapper.TaxMapper;
import com.allianz.example.model.AddressDTO;
import com.allianz.example.model.TaxDTO;
import com.allianz.example.model.requestDTO.TaxRequestDTO;
import com.allianz.example.util.BaseService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TaxService extends BaseService<TaxDTO, TaxEntity, TaxRequestDTO> {
    @Autowired
    private TaxEntityRepository taxRepository;
    @Autowired
    private TaxMapper taxMapper;

    @Override
    public TaxDTO save(TaxRequestDTO taxRequestDTO) {
        TaxEntity tax = taxMapper.requestDTOToEntity(taxRequestDTO);
        taxRepository.save(tax);
        return taxMapper.entityToDTO(tax);
    }

    @Override
    public List<TaxDTO> getAll() {
        List<TaxEntity> taxEntities = taxRepository.findAll();
        return taxMapper.entityListToDTOList(taxEntities);
    }

    @Override
    public TaxDTO update(UUID uuid, TaxRequestDTO taxRequestDTO) {
        TaxEntity taxEntity = taxRepository.findByUuid(uuid).orElse(null);
        if (taxEntity == null) {
            return null;
        }
        return taxMapper.entityToDTO(taxRepository.save(taxMapper.requestDtoToExistEntity(taxRequestDTO, taxEntity)));
    }

    @Override
    public Boolean delete(UUID uuid) {
        TaxEntity taxEntity = taxRepository.findByUuid(uuid).orElse(null);
        if (taxEntity == null) {
            return false;
        }
        taxRepository.delete(taxEntity);
        return true;
    }

    @Override
    public TaxDTO getSettingByUuid(UUID uuid) {
        TaxEntity taxEntity = taxRepository.findByUuid(uuid).orElse(null);
        if (taxEntity == null) {
            return null;
        }
        return taxMapper.entityToDTO(taxEntity);
    }

}
