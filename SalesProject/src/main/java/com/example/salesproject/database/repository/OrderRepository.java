package com.example.salesproject.database.repository;

import com.example.salesproject.database.entity.OrderEntity;
import com.example.salesproject.util.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends BaseRepository<OrderEntity> {
}
