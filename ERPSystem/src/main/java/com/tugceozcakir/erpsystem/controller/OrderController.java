package com.tugceozcakir.erpsystem.controller;

import com.tugceozcakir.erpsystem.database.entity.CustomerEntity;
import com.tugceozcakir.erpsystem.database.entity.OrderEntity;
import com.tugceozcakir.erpsystem.service.CustomerService;
import com.tugceozcakir.erpsystem.service.OrderService;
import com.tugceozcakir.erpsystem.util.StatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("orders")
public class OrderController {
    @Autowired
    OrderService orderService;
    @GetMapping("/all-order")
    public ResponseEntity<List<OrderEntity>> getAll() {
        return new ResponseEntity<>(orderService.getAll(), HttpStatus.OK);
    }
    @GetMapping("get/{uuid}")
    public ResponseEntity<OrderEntity> getByUuid(@PathVariable UUID uuid) {
        return new ResponseEntity<>(orderService.getByUuid(uuid), HttpStatus.OK);
    }

    @PostMapping("create-order")
    public ResponseEntity<Boolean> createCustomerOrder(@RequestBody OrderEntity customerOrder) {
        return new ResponseEntity<>(orderService.createOrder(customerOrder.getCustomer(),
                customerOrder.getProductList()), HttpStatus.CREATED);
    }

    @PutMapping("update-order/{uuid}")
    public ResponseEntity<Boolean> updateOrder(@PathVariable UUID uuid, @RequestBody OrderEntity order) {
        return new ResponseEntity<>(orderService.updateCustomerOrderEntity(uuid, order), HttpStatus.OK);
    }

    @DeleteMapping("delete-order/{uuid}")
    public ResponseEntity<Boolean> deleteOrder(@PathVariable UUID uuid) {
        return new ResponseEntity<>(orderService.deleteOrderEntity(uuid), HttpStatus.OK);
    }

    @PostMapping("add/{orderuuid}/{productuuid}")
    public ResponseEntity<Boolean> addProductToOrder(@PathVariable UUID orderuuid,
                                                             @PathVariable UUID productuuid)
    {
        return new ResponseEntity<>(orderService.addProductToOrder(orderuuid, productuuid), HttpStatus.OK);
    }
    @PostMapping("approve/{orderUuid}")
    public ResponseEntity<OrderEntity> approveOrder(@PathVariable UUID orderUuid) {
        return new ResponseEntity<>(orderService.checkOrder(orderUuid)
                , HttpStatus.OK);
    }
}
