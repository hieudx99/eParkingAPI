package com.example.eparking.service.imp;

import com.example.eparking.model.PaymentMethod;
import com.example.eparking.repository.PaymentMethodRepository;
import com.example.eparking.service.PaymentMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentMethodServiceImp implements PaymentMethodService {

    @Autowired
    PaymentMethodRepository paymentMethodRepository;

    @Override
    public List<PaymentMethod> getListPaymentMethod() {
        return paymentMethodRepository.findAll();
    }
}
