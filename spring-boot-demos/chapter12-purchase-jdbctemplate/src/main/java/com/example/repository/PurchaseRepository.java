package com.example.repository;

import com.example.model.Purchase;
import java.util.List;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

@Repository
public class PurchaseRepository {

  private final JdbcClient jdbc;

  public PurchaseRepository(JdbcClient jdbc) {
    this.jdbc = jdbc;
  }

  public void storePurchase(Purchase purchase) {
    String sql = "INSERT INTO purchase VALUES (NULL, ?, ?)";
    jdbc.sql(sql).param(purchase.getProduct()).param(purchase.getPrice()).update();
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

    return jdbc.sql(sql).query(purchaseRowMapper).list();
  }
}
