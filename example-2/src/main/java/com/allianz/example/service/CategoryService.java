package com.allianz.example.service;

import com.allianz.example.database.entity.CategoryEntity;
import com.allianz.example.database.entity.ProductEntity;
import com.allianz.example.database.repository.CategoryEntityRepository;
import com.allianz.example.database.repository.ProductEntityRepository;
import com.allianz.example.mapper.CategoryMapper;
import com.allianz.example.mapper.ProductMapper;
import com.allianz.example.model.CategoryDTO;
import com.allianz.example.model.ProductDTO;
import com.allianz.example.model.requestDTO.CategoryRequestDTO;
import com.allianz.example.model.requestDTO.ProductRequestDTO;
import com.allianz.example.util.BaseService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CategoryService extends BaseService<CategoryDTO, CategoryEntity, CategoryRequestDTO> {

    @Autowired
    CategoryEntityRepository categoryEntityRepository;

    @Autowired
    CategoryMapper categoryMapper;

    @Override
    public CategoryDTO save(CategoryRequestDTO categoryRequestDTO) {
        CategoryEntity category = categoryMapper.requestDTOToEntity(categoryRequestDTO);
        categoryEntityRepository.save(category);
        return categoryMapper.entityToDTO(category);
    }

    @Override
    public List<CategoryDTO> getAll() {
        List<CategoryEntity> categoryEntities = categoryEntityRepository.findAll();
        return categoryMapper.entityListToDTOList(categoryEntities);
    }

    @Override
    public CategoryDTO update(UUID uuid, CategoryRequestDTO categoryRequestDTO) {
        CategoryEntity category = categoryEntityRepository.findByUuid(uuid).orElse(null);
        if (category == null) {
            return null;
        }
        return categoryMapper.entityToDTO(categoryEntityRepository.save(categoryMapper.requestDtoToExistEntity(
                categoryRequestDTO, category)));
    }

    @Override
    public Boolean delete(UUID uuid) {
        CategoryEntity categoryEntity = categoryEntityRepository.findByUuid(uuid).orElse(null);
        if (categoryEntity == null) {
            return false;
        }
        categoryEntityRepository.delete(categoryEntity);
        return true;
    }

    @Override
    public CategoryDTO getSettingByUuid(UUID uuid) {
        CategoryEntity categoryEntity = categoryEntityRepository.findByUuid(uuid).orElse(null);
        if (categoryEntity == null) {
            return null;
        }
        return categoryMapper.entityToDTO(categoryEntity);
    }


}
