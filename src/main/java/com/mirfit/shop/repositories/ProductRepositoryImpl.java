package com.mirfit.shop.repositories;

import com.mirfit.shop.models.Product;
import com.mirfit.shop.rowmappers.ProductRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepositoryImpl implements ProductRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ProductRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Product> getProducts() {
        try {
            return jdbcTemplate.query(
                    "SELECT * FROM product",
                    new ProductRowMapper());
        } catch (Exception ex) {
            return null;
        }
    }
}
