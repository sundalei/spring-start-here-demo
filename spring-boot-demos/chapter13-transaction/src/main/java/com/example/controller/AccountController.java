package com.example.controller;

import com.example.dto.TransferRequest;
import com.example.model.Account;
import com.example.service.TransferService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
  public List<Account> getAllAccounts() {
    return transferService.getAllAccounts();
  }
}
