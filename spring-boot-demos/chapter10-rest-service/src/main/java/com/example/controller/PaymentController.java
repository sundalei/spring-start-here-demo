package com.example.controller;

import com.example.model.PaymentDetails;
import com.example.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class PaymentController {

  private final PaymentService paymentService;

  public PaymentController(PaymentService paymentService) {
    this.paymentService = paymentService;
  }

  @PostMapping("/payment")
  public ResponseEntity<?> makePayment() {
    PaymentDetails paymentDetails = paymentService.processPayment();
    return ResponseEntity.status(HttpStatus.ACCEPTED).body(paymentDetails);
  }
}
