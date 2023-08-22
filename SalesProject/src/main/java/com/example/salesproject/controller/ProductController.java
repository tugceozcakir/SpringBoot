package com.example.salesproject.controller;

import com.example.salesproject.database.entity.ProductEntity;
import com.example.salesproject.database.repository.ProductRepository;
import com.example.salesproject.database.specification.ProductSpecification;
import com.example.salesproject.mapper.ProductMapper;
import com.example.salesproject.model.ProductDTO;
import com.example.salesproject.model.requestDTO.ProductRequestDTO;
import com.example.salesproject.service.ProductService;
import com.example.salesproject.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController extends BaseController<
        ProductEntity,
        ProductDTO,
        ProductRequestDTO,
        ProductMapper,
        ProductRepository,
        ProductSpecification,
        ProductService> {
    @Autowired
    ProductService productService;


    @Override
    protected ProductService getService() {
        return productService;
    }

    @PostMapping("add-others")
    public ResponseEntity<ProductDTO> addOtherRelations(@RequestBody ProductRequestDTO productRequestDTO){
        return new ResponseEntity<>(productService.saveWithCategory(productRequestDTO), HttpStatus.OK);

    }
}
