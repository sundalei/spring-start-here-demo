package com.example.repository;

import com.example.model.Account;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, Long> {

  @Query("SELECT * FROM account WHERE name = :name")
  List<Account> findAccountsByName(String name);

  @Query("SELECT * FROM account WHERE name LIKE :namePattern")
  List<Account> findAccountsByNamePattern(String namePattern);

  @Modifying
  @Query("UPDATE account SET amount = :amount WHERE id = :id")
  void changeAmount(long id, BigDecimal amount);
}
