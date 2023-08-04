package com.tugceozcakir.erpsystem.controller;

import com.tugceozcakir.erpsystem.database.entity.*;
import com.tugceozcakir.erpsystem.service.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/order-items")
public class OrderItemController {

    @Autowired
    private OrderItemService orderItemService;

    @Autowired
    private ProductService productService;

    @Autowired
    private TaxService taxService;

    @PostMapping("/add")
    public OrderItemEntity addOrderItem(@RequestBody OrderItemEntity orderItem) {
        Long productId = orderItem.getProduct().getId();
        Long taxId = orderItem.getTax().getId();
        ProductEntity product = productService.getProductById(productId);
        TaxEntity tax = taxService.getTaxById(taxId);
        orderItem.setProduct(product);
        orderItem.setTax(tax);
        return orderItemService.addOrderItem(orderItem);
    }

    @GetMapping("/all")
    public List<OrderItemEntity> getAllOrderItems() {
        return orderItemService.getAllOrderItems();
    }

    @Modifying
    @Transactional
    @PutMapping("/update/{orderItemId}")
    public OrderItemEntity updateOrderItem(@PathVariable Long orderItemId, @RequestBody OrderItemEntity updatedOrderItem) {
        return orderItemService.updateOrderItem(orderItemId, updatedOrderItem);
    }

    @Modifying
    @Transactional
    @DeleteMapping("/delete/{orderItemId}")
    public void deleteOrderItem(@PathVariable Long orderItemId) {
        orderItemService.deleteOrderItem(orderItemId);
    }
}

