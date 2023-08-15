package com.tugceozcakir.customerregistationapp.service;

import com.tugceozcakir.customerregistationapp.database.entity.CustomerEntity;
import com.tugceozcakir.customerregistationapp.model.CustomerDTO;
import com.tugceozcakir.customerregistationapp.model.CustomerSaveDTO;
import com.tugceozcakir.customerregistationapp.model.CustomerUpdateDTO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CustomerService {
    String addCustomer(CustomerSaveDTO customerSaveDTO);
    List<CustomerDTO> getAllCustomer();
    String updateCustomer(CustomerUpdateDTO customerUpdateDTO);

    String deleteCustomer(Long id, CustomerDTO customerDTO);
}
