package com.example.salesproject.database.repository;

import com.example.salesproject.database.entity.CustomerEntity;
import com.example.salesproject.util.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends BaseRepository<CustomerEntity> {
}
