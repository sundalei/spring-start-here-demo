package com.example.controller;

import com.example.exception.NotEnoughMoneyException;
import com.example.model.ErrorDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionControllerAdvice {

  private static Logger LOG = LoggerFactory.getLogger(ExceptionControllerAdvice.class);

  @ExceptionHandler(NotEnoughMoneyException.class)
  public ResponseEntity<ErrorDetails> exceptionNotEnoughMoneyHandler(NotEnoughMoneyException e) {
    // LOG.info("exception handler", e);
    ErrorDetails errorDetails = new ErrorDetails();
    errorDetails.setMessage("Not enough money to make the payment");
    return ResponseEntity.badRequest().body(errorDetails);
  }
}
