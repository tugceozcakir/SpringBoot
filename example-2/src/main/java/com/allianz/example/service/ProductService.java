package com.allianz.example.service;

import com.allianz.example.database.entity.ProductEntity;
import com.allianz.example.database.entity.SellerEntity;
import com.allianz.example.database.entity.TaxEntity;
import com.allianz.example.database.repository.ProductEntityRepository;
import com.allianz.example.database.repository.SellerEntityRepository;
import com.allianz.example.database.repository.TaxEntityRepository;
import com.allianz.example.mapper.ProductMapper;
import com.allianz.example.mapper.SellerMapper;
import com.allianz.example.model.ProductDTO;
import com.allianz.example.model.SellerDTO;
import com.allianz.example.model.requestDTO.ProductRequestDTO;
import com.allianz.example.model.requestDTO.SellerRequestDTO;
import com.allianz.example.util.BaseService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductService extends BaseService<ProductDTO, ProductEntity, ProductRequestDTO> {
    @Autowired
    ProductEntityRepository productEntityRepository;
    @Autowired
    ProductMapper productMapper;

    @Override
    public ProductDTO save(ProductRequestDTO productRequestDTO) {
        ProductEntity product = productMapper.requestDTOToEntity(productRequestDTO);
        productEntityRepository.save(product);
        return productMapper.entityToDTO(product);
    }

    @Override
    public List<ProductDTO> getAll() {
        List<ProductEntity> productEntities = productEntityRepository.findAll();
        return productMapper.entityListToDTOList(productEntities);
    }

    @Override
    public ProductDTO update(UUID uuid, ProductRequestDTO productRequestDTO) {
        ProductEntity product = productEntityRepository.findByUuid(uuid).orElse(null);
        if (product == null) {
            return null;
        }
        return productMapper.entityToDTO(productEntityRepository.save(productMapper.requestDtoToExistEntity(
                productRequestDTO, product)));
    }

    @Override
    public Boolean delete(UUID uuid) {
        ProductEntity productEntity = productEntityRepository.findByUuid(uuid).orElse(null);
        if (productEntity == null) {
            return false;
        }
        productEntityRepository.delete(productEntity);
        return true;
    }

    @Override
    public ProductDTO getSettingByUuid(UUID uuid) {
        ProductEntity productEntity = productEntityRepository.findByUuid(uuid).orElse(null);
        if (productEntity == null) {
            return null;
        }
        return productMapper.entityToDTO(productEntity);
    }


}