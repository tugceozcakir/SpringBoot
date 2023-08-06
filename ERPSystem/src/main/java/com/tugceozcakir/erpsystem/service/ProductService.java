package com.tugceozcakir.erpsystem.service;

import com.tugceozcakir.erpsystem.database.entity.ProductEntity;
import com.tugceozcakir.erpsystem.database.entity.TaxEntity;
import com.tugceozcakir.erpsystem.database.repository.ProductRepository;
import com.tugceozcakir.erpsystem.database.repository.TaxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    TaxRepository taxRepository;

    public boolean createProduct(String name, boolean isKdvApplied, BigDecimal price, Integer stock, TaxEntity tax) {
        if (name == null || price == null || stock == null || tax == null) {
            return false;
        } else {
            TaxEntity existingTax = taxRepository.findByUuid(tax.getUuid());
            if (existingTax == null) {
                taxRepository.save(tax);
            } else {
                tax = existingTax;
            }
            ProductEntity productEntity = new ProductEntity();
            productEntity.setName(name);
            productEntity.setIsKdvApplied(isKdvApplied);
            productEntity.setPrice(price);
            productEntity.setStock(stock);
            productEntity.setOrderCount(1);
            productEntity.setTax(tax);
            isTaxTrue(productEntity);
            productRepository.save(productEntity);
            return true;
        }
    }
    public boolean updateProduct(UUID uuid, ProductEntity productEntity) {
        if (productEntity == null)
            return false;
        else {
            ProductEntity existingProduct = productRepository.findByUuid(uuid);
            if (existingProduct == null)
                return false;
            existingProduct.setName(productEntity.getName());
            existingProduct.setIsKdvApplied(productEntity.getIsKdvApplied());
            existingProduct.setPrice(productEntity.getPrice());
            existingProduct.setNonKdvAppliedPrice(productEntity.getNonKdvAppliedPrice());
            existingProduct.setStock(productEntity.getStock());
            existingProduct.setTax(productEntity.getTax());
            isTaxTrue(existingProduct);
            productRepository.save(existingProduct);
            return true;
        }
    }
    public List<ProductEntity> getAll() {
        return productRepository.findAll();
    }

    public boolean deleteProduct(UUID uuid) {
        if (uuid == null)
            return false;
        else {
            productRepository.deleteByUuid(uuid);
            return true;
        }
    }
    public ProductEntity getByUuid(UUID uuid) {
        return productRepository.findByUuid(uuid);
    }

    public List<ProductEntity> getAllByNameContainsIgnoreCase(String name) {
        return productRepository.findAllByNameContainsIgnoreCase(name);
    }
    public void isTaxTrue(ProductEntity product) {
        if (product.getTax() == null) {
            TaxEntity taxEntity = new TaxEntity();
            taxEntity.setPercent(10.0);
            product.setTax(taxEntity);
        }
        BigDecimal tax = BigDecimal.valueOf(product.getTax().getPercent());
        BigDecimal price = product.getPrice();
        if (!product.getIsKdvApplied()) {
            product.setNonKdvAppliedPrice(price);
            BigDecimal kdvPrice = price.multiply(tax);
            BigDecimal totalPrice = price.add(kdvPrice);
            product.setPrice(totalPrice);
        } else {
            BigDecimal kdvPrice = price.multiply(tax.divide(BigDecimal.valueOf(100)));
            BigDecimal nonKdvPrice = price.subtract(kdvPrice);
            product.setNonKdvAppliedPrice(nonKdvPrice);
        }
    }
}
