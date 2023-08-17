package com.tugceozcakir.customerregistationapp.service;

import com.tugceozcakir.customerregistationapp.database.entity.CustomerEntity;
import com.tugceozcakir.customerregistationapp.model.CustomerDTO;
import com.tugceozcakir.customerregistationapp.model.CustomerSaveDTO;
import com.tugceozcakir.customerregistationapp.model.CustomerUpdateDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    String addCustomer(CustomerSaveDTO customerSaveDTO);
    List<CustomerDTO> getAllCustomer();
    String updateCustomer(Long id, CustomerUpdateDTO customerUpdateDTO);
    Boolean deleteById(Long id);

}
