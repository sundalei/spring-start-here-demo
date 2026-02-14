package com.example.service;

import com.example.model.Account;
import com.example.repository.AccountRepository;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransferService {

  private final AccountRepository accountRepository;

  public TransferService(AccountRepository accountRepository) {
    this.accountRepository = accountRepository;
  }

  @Transactional
  public void transferMoney(long idSender, long idReceiver, BigDecimal amount) {
    if (amount.compareTo(BigDecimal.ZERO) < 0) {
      throw new IllegalArgumentException("Transfer amount must be positive");
    }
    if (idSender == idReceiver) {
      throw new IllegalArgumentException("Sender and Receiver cannot be the same");
    }

    Account sender = accountRepository.findAccountById(idSender);
    Account receiver = accountRepository.findAccountById(idReceiver);

    if (sender.amount().compareTo(amount) < 0) {
      throw new IllegalArgumentException("Sender has insufficient funds");
    }

    BigDecimal senderNewAmount = sender.amount().subtract(amount);
    BigDecimal receiverNewAmount = receiver.amount().add(amount);

    accountRepository.changeAmount(idSender, senderNewAmount);
    accountRepository.changeAmount(idReceiver, receiverNewAmount);
  }

  public List<Account> getAllAccounts() {
    return accountRepository.findAllAccounts();
  }
}
