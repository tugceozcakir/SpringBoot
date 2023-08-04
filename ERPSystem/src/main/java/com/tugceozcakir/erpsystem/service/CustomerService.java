package com.tugceozcakir.erpsystem.service;

import com.tugceozcakir.erpsystem.database.entity.CustomerEntity;
import com.tugceozcakir.erpsystem.database.repository.CustomerRepository;
import com.tugceozcakir.erpsystem.model.Customer;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    //All customer
    public List<CustomerEntity> getAllCustomers() {
        return customerRepository.findAll();
    }

    //Add customer
    public CustomerEntity addCustomer(CustomerEntity customer) {
        return customerRepository.save(customer);
    }

    //Update customer
    public CustomerEntity updateCustomer(Long customerId, CustomerEntity updatedCustomer) {
        CustomerEntity existingCustomer = customerRepository.findById(customerId)
                .orElseThrow(() -> new NoSuchElementException("Customer not found with ID: " + customerId));
        existingCustomer.setName(updatedCustomer.getName());
        existingCustomer.setEmail(updatedCustomer.getEmail());
        existingCustomer.setAddress(updatedCustomer.getAddress());

        return customerRepository.save(existingCustomer);
    }

    //Delete customer
    public void deleteCustomer(Long customerId) {
        customerRepository.deleteById(customerId);
    }

    //Get customer by ID
    public CustomerEntity getCustomerById(Long customerId) {
        return customerRepository.findById(customerId)
                .orElseThrow(() -> new NoSuchElementException("Customer not found with ID: " + customerId));
    }
}

