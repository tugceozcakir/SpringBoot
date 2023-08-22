package com.example.salesproject.service;

import com.example.salesproject.database.entity.CategoryEntity;
import com.example.salesproject.database.repository.CategoryRepository;
import com.example.salesproject.database.specification.CategorySpecification;
import com.example.salesproject.mapper.CategoryMapper;
import com.example.salesproject.model.CategoryDTO;
import com.example.salesproject.model.requestDTO.CategoryRequestDTO;
import com.example.salesproject.util.BaseRepository;
import com.example.salesproject.util.BaseService;
import com.example.salesproject.util.IBaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService extends BaseService<CategoryEntity, CategoryDTO, CategoryRequestDTO,
        CategoryMapper, CategoryRepository, CategorySpecification> {

    @Autowired
    CategoryRepository categoryEntityRepository;

    @Autowired
    CategoryMapper categoryMapper;
    @Autowired
    CategorySpecification categorySpecification;

    @Override
    protected CategoryMapper getMapper() {
        return this.categoryMapper;
    }

    @Override
    protected CategoryRepository getRepository() {
        return this.categoryEntityRepository;
    }

    @Override
    protected CategorySpecification getSpecification() {
        return categorySpecification;
    }
}

