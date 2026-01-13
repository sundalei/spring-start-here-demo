package com.example.controller;

import com.example.exception.NotEnoughMoneyException;
import com.example.model.ErrorDetails;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class ExceptionControllerAdvice {

  @ExceptionHandler(NotEnoughMoneyException.class)
  public ResponseEntity<ErrorDetails> exceptionNotEnoughMoneyHandler() {
    ErrorDetails errorDetails = new ErrorDetails();
    errorDetails.setMessage("Not enough money to make the payment");
    return ResponseEntity.badRequest().body(errorDetails);
  }
}
