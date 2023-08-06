package com.tugceozcakir.erpsystem.controller;

import com.tugceozcakir.erpsystem.database.entity.ProductEntity;
import com.tugceozcakir.erpsystem.service.ProductService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("products")
public class ProductController {
    @Autowired
    ProductService productService;
    @PostMapping("create-product")
    public ResponseEntity<Boolean> createProduct(@RequestBody ProductEntity product) {
        return new ResponseEntity<>(productService.createProduct(product.getName(), product.getIsKdvApplied(),
                product.getPrice(),product.getStock(),
                product.getTax()), HttpStatus.CREATED);
    }
    @GetMapping("/all-product")
    public ResponseEntity<List<ProductEntity>> getAllProduct() {
        return new ResponseEntity<>(productService.getAll(), HttpStatus.OK);
    }

    @GetMapping("get/{uuid}")
    public ResponseEntity<ProductEntity> getByUuid(@PathVariable UUID uuid) {
        return new ResponseEntity<>(productService.getByUuid(uuid), HttpStatus.OK);
    }

    @GetMapping("getByName/{name}")
    public ResponseEntity<List<ProductEntity>> getByName(@PathVariable String name) {
        return new ResponseEntity<>(productService.getAllByNameContainsIgnoreCase(name), HttpStatus.OK);
    }

    @Modifying
    @Transactional
    @GetMapping("delete-product/{uuid}")
    public ResponseEntity<Boolean> deleteByUuid(@PathVariable UUID uuid) {
        return new ResponseEntity<>(productService.deleteProduct(uuid), HttpStatus.OK);
    }

    @Modifying
    @Transactional
    @PutMapping("update-product/{uuid}")
    public ResponseEntity<Boolean> updateByUuid(@PathVariable UUID uuid, @RequestBody ProductEntity product) {
        return new ResponseEntity<>(productService.updateProduct(uuid, product), HttpStatus.OK);
    }
}