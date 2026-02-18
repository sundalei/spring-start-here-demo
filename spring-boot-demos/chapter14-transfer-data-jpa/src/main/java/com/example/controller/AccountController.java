package com.example.controller;

import com.example.dto.TransferRequest;
import com.example.model.Account;
import com.example.service.TransferService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

  private final TransferService transferService;

  public AccountController(TransferService transferService) {
    this.transferService = transferService;
  }

  @PostMapping("/transfer")
  public void transferMoney(@RequestBody TransferRequest request) {
    transferService.transferMoney(
        request.senderAccountId(), request.receiverAccountId(), request.amount());
  }

  @GetMapping("/accounts")
  public Iterable<Account> getAllAccounts(
      @RequestParam(required = false) String name,
      @RequestParam(required = false) String namePattern) {
    if (namePattern != null) {
      return transferService.findAccountsByNamePattern(namePattern);
    } else if (name != null) {
      return transferService.findAccountsByName(name);
    } else {
      return transferService.getAllAccounts();
    }
  }
}
