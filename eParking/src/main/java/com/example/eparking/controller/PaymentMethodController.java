package com.example.eparking.controller;


import com.example.eparking.model.PaymentMethod;
import com.example.eparking.service.PaymentMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/payment-method")
public class PaymentMethodController {

    @Autowired
    private PaymentMethodService paymentMethodService;

    @GetMapping("/get-list-payment-method")
    public List<PaymentMethod> getListPaymentMethod() {
        return paymentMethodService.getListPaymentMethod();
    }
}
