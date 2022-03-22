package com.example.eparking.service.imp;

import com.example.eparking.model.Customer;
import com.example.eparking.repository.CustomerRepository;
import com.example.eparking.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerServiceImp implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Optional<Customer> findByUsernameAndPassword(String username, String password) {
        return customerRepository.findByUsernameAndPassword(username, password);
    }

    @Override
    public Optional<Customer> findById(int id) {
        return customerRepository.findById(id);
    }

    @Override
    public Customer register(Customer customer) {
        return customerRepository.saveAndFlush(customer);
    }
}
