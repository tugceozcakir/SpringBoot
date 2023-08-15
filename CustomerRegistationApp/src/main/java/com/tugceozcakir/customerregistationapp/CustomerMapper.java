package com.tugceozcakir.customerregistationapp;

import com.tugceozcakir.customerregistationapp.database.entity.CustomerEntity;
import com.tugceozcakir.customerregistationapp.model.CustomerDTO;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {

    public CustomerDTO entityToDTO(CustomerEntity entity) {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setId(entity.getId());
        customerDTO.setName(entity.getName());
        customerDTO.setAddress(entity.getAddress());
        customerDTO.setMobile(entity.getMobile());

        return customerDTO;
    }

}
