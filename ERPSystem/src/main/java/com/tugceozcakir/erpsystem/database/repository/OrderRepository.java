package com.tugceozcakir.erpsystem.database.repository;

import com.tugceozcakir.erpsystem.database.entity.OrderEntity;
import com.tugceozcakir.erpsystem.util.StatusEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
    OrderEntity findByUuid(UUID uuid);
    void deleteByUuid(UUID uuid);
    List<OrderEntity> getCustomerOrderEntitiesByStatus(StatusEnum statusEnum);
}
