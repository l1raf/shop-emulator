package com.mirfit.shop.repository;

import com.mirfit.shop.models.Product;
import com.mirfit.shop.rowmappers.ProductRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ShopRepositoryImpl implements ShopRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ShopRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Product> getProducts() {
        try {
            List<Product> products = jdbcTemplate.query(
                    "SELECT * FROM products",
                    new ProductRowMapper());

            return products;

        } catch (Exception ex) {
            return null;
        }
    }
}
