package com.tugceozcakir.erpsystem.controller;

import com.tugceozcakir.erpsystem.database.entity.CustomerEntity;
import com.tugceozcakir.erpsystem.model.Customer;
import com.tugceozcakir.erpsystem.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/all")
    public List<CustomerEntity> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @PostMapping("/add")
    public CustomerEntity addCustomer(@RequestBody CustomerEntity customer) {
        return customerService.addCustomer(customer);
    }

    @PutMapping("/update/{customerId}")
    public CustomerEntity updateCustomer(@PathVariable Long customerId, @RequestBody CustomerEntity updatedCustomer) {
        return customerService.updateCustomer(customerId, updatedCustomer);
    }

    @DeleteMapping("/delete/{customerId}")
    public void deleteCustomer(@PathVariable Long customerId) {
        customerService.deleteCustomer(customerId);
    }
}

