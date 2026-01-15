package com.example.controller;

import com.example.model.Payment;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class PaymentController {

  @PostMapping("/payment")
  public ResponseEntity<Payment> createPayment(
      @RequestHeader("requestId") String requestId, @RequestBody Payment payment) {
    log.info("Received request with ID {} ; Payment Amount: {}", requestId, payment.amount());

    Payment processedPayment = new Payment(UUID.randomUUID().toString(), payment.amount());

    return ResponseEntity.status(HttpStatus.OK)
        .header("requestId", requestId)
        .body(processedPayment);
  }
}
