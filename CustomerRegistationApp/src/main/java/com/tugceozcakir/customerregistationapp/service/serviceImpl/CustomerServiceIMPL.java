package com.tugceozcakir.customerregistationapp.service.serviceImpl;

import com.tugceozcakir.customerregistationapp.CustomerMapper;
import com.tugceozcakir.customerregistationapp.database.entity.CustomerEntity;
import com.tugceozcakir.customerregistationapp.database.repository.CustomerRepository;
import com.tugceozcakir.customerregistationapp.model.CustomerDTO;
import com.tugceozcakir.customerregistationapp.model.CustomerSaveDTO;
import com.tugceozcakir.customerregistationapp.model.CustomerUpdateDTO;
import com.tugceozcakir.customerregistationapp.service.CustomerService;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceIMPL implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CustomerMapper customerMapper;

    @Override
    public String addCustomer(CustomerSaveDTO customerSaveDTO) {
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setName(customerSaveDTO.getName());
        customerEntity.setAddress(customerSaveDTO.getAddress());
        customerEntity.setMobile(customerSaveDTO.getMobile());

        customerRepository.save(customerEntity);

        return "{\"message\": \"Successful\"}";
    }


    @Override
    public List<CustomerDTO> getAllCustomer() {
        List<CustomerEntity> customerEntities = customerRepository.findAll();
        List<CustomerDTO> customerDTOS = new ArrayList<>();

        for(CustomerEntity a: customerEntities){
            customerDTOS.add(customerMapper.entityToDTO(a));
        }
        return customerDTOS;
    }

    @Override
    public String updateCustomer(Long id, CustomerUpdateDTO customerUpdateDTO) {
        CustomerEntity customerEntity = customerRepository.getById(id);

        if (customerEntity != null) {
            customerEntity.setMobile(customerUpdateDTO.getMobile());
            customerEntity.setName(customerUpdateDTO.getName());
            customerEntity.setAddress(customerUpdateDTO.getAddress());

            customerRepository.save(customerEntity);
            return "Success";
        } else {
            return "Customer not found for ID: " + id;
        }
    }


    @Override
    public Boolean deleteById(Long id) {
        Optional<CustomerEntity> optionalEntity = customerRepository.findById(id);
        if (optionalEntity.isPresent()) {
            customerRepository.deleteById(id);
            return Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }
    }

}
