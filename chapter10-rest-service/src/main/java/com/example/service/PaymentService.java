package com.example.service;

import org.springframework.stereotype.Service;

import com.example.exception.NotEnoughMoneyException;
import com.example.model.PaymentDetails;

@Service
public class PaymentService {
    
    public PaymentDetails processPayment() {
        throw new NotEnoughMoneyException();
    }
}
