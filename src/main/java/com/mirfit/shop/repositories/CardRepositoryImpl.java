package com.mirfit.shop.repositories;

import com.mirfit.shop.models.Card;
import com.mirfit.shop.rowmappers.CardRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CardRepositoryImpl implements CardRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CardRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Card> getCards() {
        try {
            return jdbcTemplate.query(
                    "SELECT * FROM card",
                    new CardRowMapper());
        } catch (Exception ex) {
            return null;
        }
    }
}
