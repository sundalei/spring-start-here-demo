package com.example.controller;

import com.example.model.Payment;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

  private static Logger LOGGER = LoggerFactory.getLogger(PaymentController.class);

  @PostMapping("/payment")
  public ResponseEntity<Payment> createPayment(
      @RequestHeader String requestId, @RequestBody Payment payment) {
    LOGGER.info(
        "Received request with ID " + requestId + " ; Payment Amount: " + payment.getAmount());

    payment.setId(UUID.randomUUID().toString());

    return ResponseEntity.status(HttpStatus.OK).header("requestId", requestId).body(payment);
  }
}
