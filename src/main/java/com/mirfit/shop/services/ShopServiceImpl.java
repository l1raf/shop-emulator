package com.mirfit.shop.services;

import com.mirfit.shop.models.Card;
import com.mirfit.shop.models.CheckRequest;
import com.mirfit.shop.models.Product;
import com.mirfit.shop.repositories.CardRepository;
import com.mirfit.shop.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class ShopServiceImpl implements ShopService {
    private static final Random random = new Random();
    private final ProductRepository shopRepository;
    private final CardRepository cardRepository;

    public ShopServiceImpl(ProductRepository shopRepository, CardRepository cardRepository) {
        this.shopRepository = shopRepository;
        this.cardRepository = cardRepository;
    }

    public CheckRequest sendCheck() {
        List<Product> products = generateProducts();
        CheckRequest request = new CheckRequest();

        if (products != null) {
            request = new CheckRequest(
                    generateTransactionId(),
                    countAmount(products),
                    products,
                    LocalDate.now(),
                    LocalTime.now(),
                    random.nextBoolean(),
                    getRandomCard().getNumber()
            );
        }

        return request;
    }

    private Card getRandomCard() {
        List<Card> cards = cardRepository.getCards();
        return cards.get(random.nextInt(cards.size()));
    }

    public List<Product> generateProducts() {
        List<Product> products = shopRepository.getProducts();

        if (products == null)
            return null;

        List<Product> randomProducts = new ArrayList<>();

        int numOfProducts = random.nextInt(products.size()) + 1; // 1 - 20

        for (int i = 0; i < random.nextInt(products.size()) + 1; i++) {
            randomProducts.add(products.get(random.nextInt(numOfProducts)));
        }

        return randomProducts;
    }

    private String generateTransactionId() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 16; i++) {
            sb.append(random.nextInt(10));
        }

        return sb.toString();
    }

    private double countAmount(List<Product> products) {
        double amount = 0.0;

        for (Product product : products) {
            amount += product.getPrice();
        }

        return amount;
    }
}
