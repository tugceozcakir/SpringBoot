package com.example.salesproject.service;

import com.example.salesproject.database.entity.ProductEntity;
import com.example.salesproject.database.repository.ProductRepository;
import com.example.salesproject.database.specification.ProductSpecification;
import com.example.salesproject.mapper.ProductMapper;
import com.example.salesproject.model.CategoryDTO;
import com.example.salesproject.model.ProductDTO;
import com.example.salesproject.model.requestDTO.CategoryRequestDTO;
import com.example.salesproject.model.requestDTO.ProductRequestDTO;
import com.example.salesproject.util.BaseRepository;
import com.example.salesproject.util.BaseService;
import com.example.salesproject.util.IBaseMapper;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Service
public class ProductService extends BaseService<ProductEntity, ProductDTO, ProductRequestDTO,
        ProductMapper, ProductRepository, ProductSpecification> {

    @Autowired
    ProductRepository productEntityRepository;

    @Autowired
    ProductMapper productMapper;

    @Autowired
    CategoryService categoryService;

    @Autowired
    ProductSpecification productSpecification;

    @Override
    protected ProductMapper getMapper() {
        return this.productMapper;
    }

    @Override
    protected ProductRepository getRepository() {
        return this.productEntityRepository;
    }

    @Override
    protected ProductSpecification getSpecification() {
        return productSpecification;
    }

    @Transactional
    public ProductDTO saveWithCategory(ProductRequestDTO productRequestDTO) {
        Set<CategoryRequestDTO> categoryRequestDTOS = new HashSet<>(new ArrayList<>(productRequestDTO.getCategoryList()));
        productRequestDTO.setCategoryList(null);
        productRequestDTO.setTax(null);
        ProductDTO productDTO = productMapper.entityToDTO(productEntityRepository.save(productMapper.requestDTOToEntity(productRequestDTO)));
        for (CategoryRequestDTO categoryRequestDTO : categoryRequestDTOS) {
            if (productDTO.getCategoryList() != null) {
                productDTO.getCategoryList().add(categoryService.getByUUID(categoryRequestDTO.getUuid()));
                // Relation'ı kaydet.
//                categoryService.getByUUID(categoryRequestDTO.getUuid()).setProductList();
            } else {
                Set<CategoryDTO> categoryDTOS = new HashSet<>();
                categoryDTOS.add(categoryService.getByUUID(categoryRequestDTO.getUuid()));
                productDTO.setCategoryList(categoryDTOS);
            }
        }

        getRepository().save(productMapper.dtoToEntity(productDTO));
        return productDTO;

    }
}
