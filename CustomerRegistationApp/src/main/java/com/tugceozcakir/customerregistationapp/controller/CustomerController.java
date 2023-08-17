package com.tugceozcakir.customerregistationapp.controller;

import com.tugceozcakir.customerregistationapp.database.entity.CustomerEntity;
import com.tugceozcakir.customerregistationapp.model.CustomerDTO;
import com.tugceozcakir.customerregistationapp.model.CustomerSaveDTO;
import com.tugceozcakir.customerregistationapp.model.CustomerUpdateDTO;
import com.tugceozcakir.customerregistationapp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
@CrossOrigin(origins = "http://localhost:4200")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping("/save")
    public ResponseEntity<String> saveCustomer(@RequestBody CustomerSaveDTO customerSaveDTO){
        String id = customerService.addCustomer(customerSaveDTO);
        return new ResponseEntity<>(id, HttpStatus.CREATED);
    }

    @GetMapping
    public List<CustomerDTO> getAll(){
        List<CustomerDTO> allCustomer = customerService.getAllCustomer();
        return allCustomer;
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateCustomer(@PathVariable Long id, @RequestBody CustomerUpdateDTO customerUpdateDTO) {
        String result = customerService.updateCustomer(id, customerUpdateDTO);

        if (result.equals("Success")) {
            return ResponseEntity.ok("Customer updated successfully.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id){
        Boolean isDeleted = customerService.deleteById(id);
        if (isDeleted) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
        }
    }
}
