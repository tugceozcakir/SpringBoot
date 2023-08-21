package com.tugceozcakir.dynamicfilteringexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/search")
    public ResponseEntity<List<ProductEntity>> searchProducts(
            @RequestBody List<SearchCriteria> criteriaList) {
        List<ProductEntity> products = productService.searchProducts(criteriaList);
        return ResponseEntity.ok(products);
    }

    @PostMapping("/add")
    public ResponseEntity<ProductEntity> addProduct(@RequestBody ProductEntity product) {
        ProductEntity addedProduct = productService.addProduct(product);
        return ResponseEntity.ok(addedProduct);
    }

}
