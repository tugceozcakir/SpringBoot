package com.example.salesproject.database.repository;

import com.example.salesproject.database.entity.ProductEntity;
import com.example.salesproject.util.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends BaseRepository<ProductEntity> {
}
