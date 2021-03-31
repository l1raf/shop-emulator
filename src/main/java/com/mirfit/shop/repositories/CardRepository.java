package com.mirfit.shop.repositories;

import com.mirfit.shop.models.Card;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardRepository {
    List<Card> getCards();
}
