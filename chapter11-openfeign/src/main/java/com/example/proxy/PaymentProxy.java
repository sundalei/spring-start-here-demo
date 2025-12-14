package com.example.proxy;

import com.example.model.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "payments", url = "${name.service.url}")
public interface PaymentProxy {

  @PostMapping("/payment")
  ResponseEntity<Payment> createPayment(
      @RequestHeader String requestId, @RequestBody Payment payment);
}
