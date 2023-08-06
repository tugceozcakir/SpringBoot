package com.tugceozcakir.erpsystem.service;

import com.tugceozcakir.erpsystem.database.entity.CustomerEntity;
import com.tugceozcakir.erpsystem.database.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    //All customer
    public List<CustomerEntity> getAllCustomers() {
        return customerRepository.findAll();
    }

    //Create customer
    public boolean createCustomer(String name, String email,String address) {
        if (name == null || email == null) {
            return false;
        } else {
            CustomerEntity customerEntity = new CustomerEntity();
            customerEntity.setName(name);
            customerEntity.setEmail(email);
            customerEntity.setAddress(address);
            customerRepository.save(customerEntity);
            return true;
        }
    }
    //Delete customer
    public boolean deleteCustomer(UUID uuid) {
        if (uuid == null)
            return false;
        customerRepository.deleteByUuid(uuid);
        return true;
    }
    public List<CustomerEntity> getAllByNameContains(String name) {
        return customerRepository.findAllByNameContainsIgnoreCase(name);
    }
    //Update customer
    public boolean updateCustomer(UUID uuid, CustomerEntity customerEntity) {
        if (uuid == null || customerEntity == null) {
            return false;
        } else {
            CustomerEntity existingCustomer = customerRepository.findByUuid(uuid);
            if (existingCustomer == null)
                return false;
            existingCustomer.setName(customerEntity.getName());
            existingCustomer.setEmail(customerEntity.getEmail());
            existingCustomer.setAddress(customerEntity.getAddress());
            customerRepository.save(existingCustomer);
            return true;
        }
    }
}

