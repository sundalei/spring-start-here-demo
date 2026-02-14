package com.example.repository;

import com.example.model.Account;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class AccountRowMapper implements RowMapper<Account> {

  @Override
  public Account mapRow(ResultSet resultSet, int i) throws SQLException {
    return new Account(
        resultSet.getInt("id"), resultSet.getString("name"), resultSet.getBigDecimal("amount"));
  }
}
