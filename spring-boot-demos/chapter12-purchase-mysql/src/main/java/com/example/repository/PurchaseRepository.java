package com.example.repository;

import com.example.model.Purchase;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class PurchaseRepository {

  private final JdbcTemplate jdbc;

  public PurchaseRepository(JdbcTemplate jdbc) {
    this.jdbc = jdbc;
  }

  public void storePurchase(Purchase purchase) {
    String sql = "INSERT INTO purchase (product, price) VALUES (?, ?)";

    jdbc.update(sql, purchase.getProduct(), purchase.getPrice());
  }

  public List<Purchase> findAllPurchase() {
    String sql = "SELECT * FROM purchase";

    RowMapper<Purchase> purchaseRowMapper =
        (rs, rowNum) -> {
          Purchase rowObject = new Purchase();
          rowObject.setId(rs.getInt("id"));
          rowObject.setProduct(rs.getString("product"));
          rowObject.setPrice(rs.getBigDecimal("price"));
          return rowObject;
        };

    return jdbc.query(sql, purchaseRowMapper);
  }
}
