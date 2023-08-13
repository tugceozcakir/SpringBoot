package com.allianz.example.controller;

import com.allianz.example.database.entity.ProductEntity;
import com.allianz.example.model.ProductDTO;
import com.allianz.example.model.requestDTO.ProductRequestDTO;
import com.allianz.example.service.ProductService;
import com.allianz.example.service.SellerService;
import com.allianz.example.util.BaseController;
import com.allianz.example.util.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductController extends BaseController<ProductDTO, ProductEntity, ProductRequestDTO, ProductService> {
    @Autowired
    private ProductService productService;

    @Override
    protected ProductService getBaseService(){
        return productService;
    }

}
