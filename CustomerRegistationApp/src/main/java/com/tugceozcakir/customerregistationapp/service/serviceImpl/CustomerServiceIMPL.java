package com.tugceozcakir.customerregistationapp.service.serviceImpl;

import com.tugceozcakir.customerregistationapp.CustomerMapper;
import com.tugceozcakir.customerregistationapp.database.entity.CustomerEntity;
import com.tugceozcakir.customerregistationapp.database.repository.CustomerRepository;
import com.tugceozcakir.customerregistationapp.model.CustomerDTO;
import com.tugceozcakir.customerregistationapp.model.CustomerSaveDTO;
import com.tugceozcakir.customerregistationapp.model.CustomerUpdateDTO;
import com.tugceozcakir.customerregistationapp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

        return "Success";
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
    public String updateCustomer(CustomerUpdateDTO customerUpdateDTO) {
        if(customerRepository.existsById(customerUpdateDTO.getId())){
            CustomerEntity customerEntity = customerRepository.getById(customerUpdateDTO.getId());
            customerEntity.setMobile(customerUpdateDTO.getMobile());
            customerEntity.setId(customerUpdateDTO.getId());
            customerEntity.setName(customerUpdateDTO.getName());
            customerEntity.setAddress(customerUpdateDTO.getAddress());

            customerRepository.save(customerEntity);
            return "Success";
        } else{
            return "Customer Id don't exist.";
        }
    }

    @Override
    public String deleteCustomer(Long id,CustomerDTO customerDTO) {
        CustomerEntity customerEntity = new CustomerEntity();

        return null;
    }

}
