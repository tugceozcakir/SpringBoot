package com.allianz.example.service;

import com.allianz.example.database.entity.CategoryEntity;
import com.allianz.example.database.entity.ProductEntity;
import com.allianz.example.database.entity.TaxEntity;
import com.allianz.example.database.repository.CategoryEntityRepository;
import com.allianz.example.database.repository.ProductEntityRepository;
import com.allianz.example.mapper.CategoryMapper;
import com.allianz.example.mapper.ProductMapper;
import com.allianz.example.model.CategoryDTO;
import com.allianz.example.model.ProductDTO;
import com.allianz.example.model.TaxDTO;
import com.allianz.example.model.requestDTO.CategoryRequestDTO;
import com.allianz.example.model.requestDTO.ProductRequestDTO;
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
public class CategoryService extends BaseService<CategoryEntity, CategoryDTO,
        CategoryRequestDTO, IBaseMapper<CategoryDTO, CategoryEntity, CategoryRequestDTO>,
        IBaseRepository<CategoryEntity>> {
    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private CategoryEntityRepository categoryEntityRepository;


    @Override
    public CategoryMapper getMapper() {
        return categoryMapper;
    }

    @Override
    public CategoryEntityRepository getRepository() {
        return categoryEntityRepository;
    }
}
