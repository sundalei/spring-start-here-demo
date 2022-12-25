package com.example.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.PaymentDetails;

@RestController
public class PaymentController {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(PaymentController.class);

    @PostMapping("/payment")
    public ResponseEntity<?> makePayment(@RequestBody PaymentDetails paymentDetails) {

        LOGGER.info("Received payment " +  paymentDetails.getAmount());
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(paymentDetails);
    }
}
