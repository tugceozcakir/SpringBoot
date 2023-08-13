package com.allianz.example.mapper;

import com.allianz.example.database.entity.CategoryEntity;
import com.allianz.example.database.entity.ProductEntity;
import com.allianz.example.model.CategoryDTO;
import com.allianz.example.model.ProductDTO;
import com.allianz.example.model.requestDTO.CategoryRequestDTO;
import com.allianz.example.model.requestDTO.ProductRequestDTO;
import com.allianz.example.util.IBaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class ProductMapper implements IBaseMapper<ProductDTO, ProductEntity, ProductRequestDTO> {

    @Autowired
    TaxMapper taxMapper;

    @Autowired
    @Lazy
    CategoryMapper categoryMapper;

    @Override
    public ProductDTO entityToDTO(ProductEntity entity) {
        ProductDTO dto = new ProductDTO();
        dto.setId(entity.getId());
        dto.setUuid(entity.getUuid());
        dto.setCreationDate(entity.getCreationDate());
        dto.setUpdatedDate(entity.getUpdatedDate());
        dto.setName(entity.getName());
        dto.setCode(entity.getCode());
        dto.setQuantity(entity.getQuantity());
        dto.setColor(entity.getColor());
        dto.setTax(taxMapper.entityToDTO(entity.getTax()));
        dto.setSellPrice(entity.getSellPrice());
        dto.setBuyPrice(entity.getBuyPrice());
        Set<CategoryDTO> categoryDTOS =
                new HashSet<>(new ArrayList<>(categoryMapper.entityListToDTOList(new ArrayList<>(entity.getCategoryList()))));
        dto.setCategoryList(categoryDTOS);

        return dto;
    }

    @Override
    public ProductEntity dtoToEntity(ProductDTO dto) {
        ProductEntity entity = new ProductEntity();
        entity.setId(dto.getId());
        entity.setUuid(dto.getUuid());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUpdatedDate(dto.getUpdatedDate());
        entity.setName(dto.getName());
        entity.setCode(dto.getCode());
        entity.setQuantity(dto.getQuantity());
        entity.setColor(dto.getColor());
        entity.setTax(taxMapper.dtoToEntity(dto.getTax()));
        entity.setSellPrice(dto.getSellPrice());
        entity.setBuyPrice(dto.getBuyPrice());
        Set<CategoryEntity> categoryDTOS =
                new HashSet<>(new ArrayList<>(categoryMapper.dtoListTOEntityList(new ArrayList<>(dto.getCategoryList()))));
        entity.setCategoryList(categoryDTOS);

        return entity;
    }

    @Override
    public List<ProductDTO> entityListToDTOList(List<ProductEntity> productEntities) {
        List<ProductDTO> dtoList = new ArrayList<>();
        for (ProductEntity entity : productEntities) {
            ProductDTO dto = entityToDTO(entity);
            dtoList.add(dto);
        }
        return dtoList;
    }

    @Override
    public List<ProductEntity> dtoListTOEntityList(List<ProductDTO> productDTOS) {
        List<ProductEntity> entityList = new ArrayList<>();
        for (ProductDTO dto : productDTOS) {
            ProductEntity entity = dtoToEntity(dto);
            entityList.add(entity);
        }
        return entityList;
    }

    @Override
    public ProductEntity requestDTOToEntity(ProductRequestDTO dto) {
        ProductEntity entity = new ProductEntity();
        entity.setId(dto.getId());
        entity.setUuid(dto.getUuid());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUpdatedDate(dto.getUpdatedDate());
        entity.setName(dto.getName());
        entity.setCode(dto.getCode());
        entity.setQuantity(dto.getQuantity());
        entity.setColor(dto.getColor());
        entity.setTax(taxMapper.requestDTOToEntity(dto.getTax()));
        entity.setSellPrice(dto.getSellPrice());
        entity.setBuyPrice(dto.getBuyPrice());
        Set<CategoryEntity> categoryDTOS =
                new HashSet<>(new ArrayList<>(categoryMapper.requestDtoListTOEntityList(new ArrayList<>(dto.getCategoryList()))));
        entity.setCategoryList(categoryDTOS);
        return entity;
    }

    @Override
    public List<ProductEntity> requestDtoListTOEntityList(List<ProductRequestDTO> productRequestDTOS) {
        return null;
    }

    @Override
    public ProductEntity requestDtoToExistEntity(ProductRequestDTO dto, ProductEntity entity) {
        return null;
    }
}

