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
import com.allianz.example.model.TaxDTO;
import com.allianz.example.model.requestDTO.ProductRequestDTO;
import com.allianz.example.model.requestDTO.SellerRequestDTO;
import com.allianz.example.model.requestDTO.TaxRequestDTO;
import com.allianz.example.util.BaseService;
import com.allianz.example.util.IBaseMapper;
import com.allianz.example.util.IBaseRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductService extends BaseService<ProductEntity, ProductDTO,
        ProductRequestDTO, IBaseMapper<ProductDTO, ProductEntity, ProductRequestDTO>, IBaseRepository<ProductEntity>> {
    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private ProductEntityRepository productEntityRepository;


    @Override
    public ProductMapper getMapper() {
        return productMapper;
    }

    @Override
    public ProductEntityRepository getRepository() {
        return productEntityRepository;
    }
}
