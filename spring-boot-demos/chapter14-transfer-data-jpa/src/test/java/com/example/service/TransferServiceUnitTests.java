package com.example.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

import com.example.exception.AccountNotFoundException;
import com.example.model.Account;
import com.example.repository.AccountRepository;
import java.math.BigDecimal;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TransferServiceUnitTests {

  private AccountRepository accountRepository;
  private TransferService transferService;

  @BeforeEach
  public void setUp() {
    accountRepository = mock(AccountRepository.class);
    transferService = new TransferService(accountRepository);
  }

  @Test
  @DisplayName("Test the amount is transferred from one account to another if no exception occurs.")
  public void moneyTransferHappyFlow() {
    Account sender = new Account();
    sender.setId(1);
    sender.setAmount(new BigDecimal(1000));

    Account destination = new Account();
    destination.setId(2);
    destination.setAmount(new BigDecimal(1000));

    given(accountRepository.findById(sender.getId())).willReturn(Optional.of(sender));

    given(accountRepository.findById(destination.getId())).willReturn(Optional.of(destination));

    transferService.transferMoney(sender.getId(), destination.getId(), new BigDecimal(100));

    verify(accountRepository).changeAmount(1, new BigDecimal(900));
    verify(accountRepository).changeAmount(2, new BigDecimal(1100));
  }

  @Test
  @DisplayName("Test the change amount is not happen if sender is not found")
  public void moneyTransferSenderNotFound() {
    Account destination = new Account();
    destination.setId(2);
    destination.setAmount(new BigDecimal(1000));

    given(accountRepository.findById(1L)).willReturn(Optional.empty());
    given(accountRepository.findById(destination.getId())).willReturn(Optional.of(destination));

    AccountNotFoundException exception =
        assertThrows(
            AccountNotFoundException.class,
            () -> transferService.transferMoney(1, destination.getId(), new BigDecimal(100)));
    assertEquals("Account with sender id 1 not found", exception.getMessage());
    verify(accountRepository, never()).changeAmount(anyLong(), any(BigDecimal.class));
  }

  @Test
  @DisplayName("Test the change amount is not happen if receiver is not found")
  public void moneyTransferReceiverNotFound() {
    Account sender = new Account();
    sender.setId(1);
    sender.setAmount(new BigDecimal(1000));

    given(accountRepository.findById(sender.getId())).willReturn(Optional.of(sender));
    given(accountRepository.findById(2L)).willReturn(Optional.empty());

    AccountNotFoundException exception =
        assertThrows(
            AccountNotFoundException.class,
            () -> transferService.transferMoney(sender.getId(), 2, new BigDecimal(100)));
    assertEquals("Account with receiver id 2 not found", exception.getMessage());
    verify(accountRepository, never()).changeAmount(anyLong(), any(BigDecimal.class));
  }

  @Test
  @DisplayName("Test the change amount is not happen if sender has no enough money")
  public void moneyTransferHasNoEnoughMoney() {
    Account sender = new Account();
    sender.setId(1);
    sender.setAmount(new BigDecimal(1000));

    Account destination = new Account();
    destination.setId(2);
    destination.setAmount(new BigDecimal(1000));

    given(accountRepository.findById(sender.getId())).willReturn(Optional.of(sender));

    given(accountRepository.findById(destination.getId())).willReturn(Optional.of(destination));

    RuntimeException exception =
        assertThrows(
            RuntimeException.class,
            () ->
                transferService.transferMoney(
                    sender.getId(), destination.getId(), new BigDecimal(1500)));
    assertEquals("Account sender has no enough money", exception.getMessage());
    verify(accountRepository, never()).changeAmount(anyLong(), any(BigDecimal.class));
  }
}
