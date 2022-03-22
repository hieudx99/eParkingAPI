package com.example.eparking.controller;

import com.example.eparking.model.Customer;
import com.example.eparking.model.dto.Credential;
import com.example.eparking.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/login")
    public Optional<Customer> checkLogin(@RequestBody Credential credential) {
        return customerService.findByUsernameAndPassword
                (credential.getUsername(), credential.getPassword());
    }



    @GetMapping("/findbyid")
    public Optional<Customer> getCustomerById(@RequestParam int id) {
        return customerService.findById(id);
    }

}
