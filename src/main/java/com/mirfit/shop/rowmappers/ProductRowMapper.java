package com.mirfit.shop.rowmappers;

import com.mirfit.shop.models.Product;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductRowMapper implements RowMapper<Product> {

    @Override
    public Product mapRow(ResultSet resultSet, int i) throws SQLException {
        return new Product(
                resultSet.getInt("id"),
                resultSet.getString("name"),
                Math.round(resultSet.getDouble("price")),
                resultSet.getString("currency_code"));
    }
}
