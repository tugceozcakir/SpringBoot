package com.tugceozcakir.dynamicfilteringexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<ProductEntity> searchProducts(List<SearchCriteria> criteriaList) {
        BaseSpecification<ProductEntity> specification = new BaseSpecification<>(criteriaList);
        return productRepository.findAll(specification);
    }

    public ProductEntity addProduct(ProductEntity product) {
        return productRepository.save(product);
    }
}