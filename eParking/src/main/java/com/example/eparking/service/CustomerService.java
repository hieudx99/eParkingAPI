package com.example.eparking.service;

import com.example.eparking.model.Customer;

import java.util.Optional;

public interface CustomerService {
    public Optional<Customer> findByUsernameAndPassword(String username, String password);
    public Optional<Customer> findById(int id);
}
