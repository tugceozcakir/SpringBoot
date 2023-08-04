package com.tugceozcakir.erpsystem.service;

import com.tugceozcakir.erpsystem.database.entity.ProductEntity;
import com.tugceozcakir.erpsystem.database.repository.ProductRepository;
import com.tugceozcakir.erpsystem.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product createProduct(String name, Double price, Double taxRate, int stockQuantity){
        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        product.setTaxRate(taxRate);
        product.setStockQuantity(stockQuantity);
        return product;
    }

    //All products
    public List<ProductEntity> getAllProducts() {
        return productRepository.findAll();
    }

    //Add new product
    public ProductEntity addProduct(ProductEntity product) {
        return productRepository.save(product);
    }

    //Update product
    public ProductEntity updateProduct(Long productId, ProductEntity updatedProduct) {
        ProductEntity existingProduct = productRepository.findById(productId)
                .orElseThrow(() -> new NoSuchElementException("Product not found with ID: " + productId));

        existingProduct.setName(updatedProduct.getName());
        existingProduct.setPrice(updatedProduct.getPrice());
        existingProduct.setTaxRate(updatedProduct.getTaxRate());
        existingProduct.setStockQuantity(updatedProduct.getStockQuantity());

        return productRepository.save(existingProduct);
    }

    //Delete product
    public void deleteProduct(Long productId) {
        productRepository.deleteById(productId);
    }

    public ProductEntity getProductById(Long productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new NoSuchElementException("Product not found with ID: " + productId));
    }
}
