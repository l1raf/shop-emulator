package com.mirfit.shop.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.mirfit.shop.models.Card;
import com.mirfit.shop.models.ReceiptRequest;
import com.mirfit.shop.models.Product;
import com.mirfit.shop.repositories.CardRepository;
import com.mirfit.shop.repositories.ProductRepository;
import okhttp3.*;
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
    private static ObjectMapper mapper = new ObjectMapper();
    private final String BASE_URL = "http://localhost:8080/bonuses";
    private static final OkHttpClient client = new OkHttpClient();
    private static final MediaType JSON = MediaType.get("application/json; charset=utf-8");

    public ShopServiceImpl(ProductRepository shopRepository, CardRepository cardRepository) {
        this.shopRepository = shopRepository;
        this.cardRepository = cardRepository;
    }

    public String sendCheck() {
        List<Product> products = generateProducts();
        ReceiptRequest request = new ReceiptRequest();

        if (products != null) {
            request = new ReceiptRequest(
                    generateTransactionId(),
                    countAmount(products),
                    products,
                    LocalDate.now(),
                    LocalTime.now(),
                    random.nextBoolean(),
                    getRandomCard().getNumber(),
                    generateCardAcceptorIdentificationCode());
        }

        return sendRequest(request);
    }

    private String sendRequest(ReceiptRequest receiptRequest) {
        try {
            mapper.registerModule(new JavaTimeModule());
            String json = mapper.writeValueAsString(receiptRequest);

            RequestBody body = RequestBody.create(JSON, json);
            Request request = new Request.Builder()
                    .url(BASE_URL)
                    .post(body)
                    .build();

            Response response = client.newCall(request).execute();
            String result = null;

            if (response.isSuccessful()) {
               result = response.body().string();
            }
            return result;
        }
        catch (Exception e) {
            return e.getMessage();
        }

    }

    private Card getRandomCard() {

        List<Card> cards = cardRepository.getCards();
        if (cards == null) {
            return null;
        }
        return cards.get(random.nextInt(cards.size()));
    }

    private String generateCardAcceptorIdentificationCode() {
        int num = random.nextInt(15) + 1;
        String code = "";

        for (int i = 0; i < num; i++) {
            code += random.nextInt(10);
        }
        return code;
    }

    public List<Product> generateProducts() {
        List<Product> products = shopRepository.getProducts();

        if (products == null)
            return null;

        List<Product> randomProducts = new ArrayList<>();

        for (int i = 0; i < random.nextInt(products.size()) + 1; i++) {
            randomProducts.add(products.get(random.nextInt(products.size())));
        }

        return randomProducts;
    }

    @Override
    public String cancelTransaction(String transactionNumber) {
        return null;
    }

    private String generateTransactionId() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 16; i++) {
            sb.append(random.nextInt(10));
        }

        return sb.toString();
    }

    private long countAmount(List<Product> products) {
        long amount = 0;

        for (Product product : products) {
            amount += product.getPrice();
        }
        return amount;
    }
}
