package com.example.service;

import com.example.exception.NotEnoughMoneyException;
import com.example.model.PaymentDetails;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

  public PaymentDetails processPayment() {
    throw new NotEnoughMoneyException();
  }
}
