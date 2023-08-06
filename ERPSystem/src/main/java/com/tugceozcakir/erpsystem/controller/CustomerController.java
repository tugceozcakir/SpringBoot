package com.tugceozcakir.erpsystem.controller;

import com.tugceozcakir.erpsystem.database.entity.CustomerEntity;
import com.tugceozcakir.erpsystem.service.CustomerService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("customers")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping("create-customer")
    public ResponseEntity<Boolean> createCustomer(@RequestBody CustomerEntity customer) {
        return new ResponseEntity<>(customerService.createCustomer(customer.getName(), customer.getEmail(),customer.getAddress()),
                HttpStatus.CREATED);
    }
    @GetMapping("/all-customer")
    public ResponseEntity<List<CustomerEntity>> getAll() {
        return new ResponseEntity<>(customerService.getAllCustomers(), HttpStatus.OK);
    }
    @GetMapping("/get/{name}")
    public ResponseEntity<List<CustomerEntity>> getAllByName(@PathVariable String name) {
        return new ResponseEntity<>(customerService.getAllByNameContains(name), HttpStatus.OK);
    }
    @Modifying
    @Transactional
    @PutMapping("update-customer/{uuid}")
    public ResponseEntity<Boolean> updateCustomerByUuid(@PathVariable UUID uuid, @RequestBody CustomerEntity customer) {
        CustomerEntity newCustomer = new CustomerEntity();
        newCustomer.setEmail(customer.getEmail());
        newCustomer.setName(customer.getName());
        newCustomer.setAddress(customer.getAddress());
        return new ResponseEntity<>(customerService.updateCustomer(uuid, newCustomer), HttpStatus.OK);
    }
    @Modifying
    @Transactional
    @DeleteMapping("delete-customer/{uuid}")
    public ResponseEntity<Boolean> deleteCustomerByUuid(@PathVariable UUID uuid) {
        return new ResponseEntity<>(customerService.deleteCustomer(uuid), HttpStatus.OK);
    }
}
