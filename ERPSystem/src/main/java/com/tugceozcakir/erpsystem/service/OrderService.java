package com.tugceozcakir.erpsystem.service;

import com.tugceozcakir.erpsystem.database.entity.*;
import com.tugceozcakir.erpsystem.database.repository.OrderRepository;
import com.tugceozcakir.erpsystem.database.repository.ProductRepository;
import com.tugceozcakir.erpsystem.util.StatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    ProductService productService;
    public boolean createOrder(CustomerEntity customer, List<ProductEntity> productEntityList)
    {
        if (productEntityList == null || customer == null){
            return false;
        } else{
            OrderEntity orderEntity = new OrderEntity();
            orderEntity.setCustomer(customer);
            orderEntity.setProductList(productEntityList);
            orderRepository.save(orderEntity);
            return true;
        }
    }
    public boolean updateCustomerOrderEntity(UUID uuid, OrderEntity customerOrderEntity) {
        if (uuid == null || customerOrderEntity == null)
            return false;
        else {
            OrderEntity existingCustomerOrder = orderRepository.findByUuid(uuid);
            if (existingCustomerOrder == null)
                return false;
            existingCustomerOrder.setCustomer(customerOrderEntity.getCustomer());
            existingCustomerOrder.setProductList(customerOrderEntity.getProductList());
            existingCustomerOrder.setStatus(customerOrderEntity.getStatus());
            orderRepository.save(existingCustomerOrder);
            return true;
        }
    }
    public boolean addProductToOrder(UUID orderUuid, UUID productUuid) {
        if (productRepository.findByUuid(productUuid).getOrderCount() == 0 || orderUuid == null || productUuid == null)
            return false;
        else {
            OrderEntity existingOrder = orderRepository.findByUuid(orderUuid);
            productRepository.findByUuid(productUuid).setOrderCount(1);
            if (existingOrder == null){
                return false;
            }
            else {
                ProductEntity product = productRepository.findByUuid(productUuid);
                if (existingOrder.getProductList().contains(product))
                {
                    for (ProductEntity productEntity : existingOrder.getProductList()) {
                        if (productEntity.getUuid().equals(productUuid))
                            productEntity.setOrderCount(productEntity.getOrderCount() + 1);
                    }
                } else
                    existingOrder.getProductList().add(product);
                orderRepository.save(existingOrder);
                return true;
            }
        }
    }
    public OrderEntity checkOrder(UUID orderUuid) {
        OrderEntity orderEntity = orderRepository.findByUuid(orderUuid);
        if (orderEntity == null){
            return null;
        }
        if (orderEntity.getStatus() == StatusEnum.WAITING) {
            for (ProductEntity productEntity : orderEntity.getProductList()) {
                if (productEntity.getStock() < productEntity.getOrderCount()) {
                    orderEntity.setStatus(StatusEnum.REJECTED);
                    orderRepository.save(orderEntity);
                } else {
                    orderEntity.setStatus(StatusEnum.APPROVED);
                    productEntity.setStock(productEntity.getStock() - productEntity.getOrderCount());
                    orderRepository.save(orderEntity);
                }
            }
        }
        calculatedTotal(orderRepository.findByUuid(orderUuid).getUuid());
        return orderEntity;
    }
    public void calculatedTotal(UUID uuid) {
        OrderEntity customerOrderEntity = orderRepository.findByUuid(uuid);
        BigDecimal newPrice = BigDecimal.valueOf(0);
        for (ProductEntity productEntity : customerOrderEntity.getProductList()) {
            BigDecimal productPrice = productEntity.getPrice().multiply(BigDecimal.valueOf(productEntity.getOrderCount()));
            newPrice = newPrice.add(productPrice);
        }
        customerOrderEntity.setTotalPrice(newPrice);
        orderRepository.save(customerOrderEntity);
    }
    public OrderEntity getByUuid(UUID uuid){
        return orderRepository.findByUuid(uuid);
    }
    public List<OrderEntity> getAll() {
        return orderRepository.findAll();
    }
    public boolean deleteOrderEntity(UUID uuid) {
        if (uuid == null){
            return false;
        }
        else {
            orderRepository.deleteByUuid(uuid);
            return true;
        }
    }
}