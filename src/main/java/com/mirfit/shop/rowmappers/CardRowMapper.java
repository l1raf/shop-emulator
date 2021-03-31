package com.mirfit.shop.rowmappers;

import com.mirfit.shop.models.Card;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class CardRowMapper implements RowMapper<Card> {
    @Override
    public Card mapRow(ResultSet resultSet, int i) throws SQLException {
        return new Card(
                resultSet.getLong("id"),
                resultSet.getDouble("number_of_bonuses"),
                UUID.fromString(resultSet.getString("user_id")),
                resultSet.getString("name"),
                resultSet.getString("number")
        );
    }
}
