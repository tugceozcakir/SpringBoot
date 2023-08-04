package com.tugceozcakir.erpsystem.controller;

import com.tugceozcakir.erpsystem.database.entity.ProductEntity;
import com.tugceozcakir.erpsystem.model.Product;
import com.tugceozcakir.erpsystem.service.ProductService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/add-product")
    public ProductEntity addProduct(@RequestBody ProductEntity product) {
        return productService.addProduct(product);
    }

    @GetMapping("/all")
    public List<ProductEntity> getAllProducts() {
        return productService.getAllProducts();
    }


    @Modifying
    @Transactional
    @PutMapping("/update/{productId}")
    public ProductEntity updateProduct(@PathVariable Long productId, @RequestBody ProductEntity updatedProduct) {
        return productService.updateProduct(productId, updatedProduct);
    }

    @Modifying
    @Transactional
    @DeleteMapping("/delete/{productId}")
    public void deleteProduct(@PathVariable Long productId) {
        productService.deleteProduct(productId);
    }
}

