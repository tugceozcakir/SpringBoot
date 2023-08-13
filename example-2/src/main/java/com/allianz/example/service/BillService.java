package com.allianz.example.service;

import com.allianz.example.database.entity.BillEntity;
import com.allianz.example.database.entity.ProductEntity;
import com.allianz.example.database.repository.BillEntityRepository;
import com.allianz.example.database.repository.ProductEntityRepository;
import com.allianz.example.mapper.BillMapper;
import com.allianz.example.mapper.ProductMapper;
import com.allianz.example.model.BillDTO;
import com.allianz.example.model.ProductDTO;
import com.allianz.example.model.requestDTO.BillRequestDTO;
import com.allianz.example.model.requestDTO.ProductRequestDTO;
import com.allianz.example.util.BaseService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BillService extends BaseService<BillDTO, BillEntity, BillRequestDTO> {

    @Autowired
    BillEntityRepository billEntityRepository;

    @Autowired
    BillMapper billMapper;

    @Override
    public BillDTO save(BillRequestDTO billRequestDTO) {
        BillEntity bill = billMapper.requestDTOToEntity(billRequestDTO);
        billEntityRepository.save(bill);
        return billMapper.entityToDTO(bill);
    }

    @Override
    public List<BillDTO> getAll() {
        List<BillEntity> billEntities = billEntityRepository.findAll();
        return billMapper.entityListToDTOList(billEntities);
    }

    @Override
    public BillDTO update(UUID uuid, BillRequestDTO billRequestDTO) {
        BillEntity bill = billEntityRepository.findByUuid(uuid).orElse(null);
        if (bill == null) {
            return null;
        }
        return billMapper.entityToDTO(billEntityRepository.save(billMapper.requestDtoToExistEntity(
                billRequestDTO, bill)));
    }

    @Override
    public Boolean delete(UUID uuid) {
        BillEntity billEntity = billEntityRepository.findByUuid(uuid).orElse(null);
        if (billEntity == null) {
            return false;
        }
        billEntityRepository.delete(billEntity);
        return true;
    }

    @Override
    public BillDTO getSettingByUuid(UUID uuid) {
        BillEntity billEntity = billEntityRepository.findByUuid(uuid).orElse(null);
        if (billEntity == null) {
            return null;
        }
        return billMapper.entityToDTO(billEntity);
    }


}
