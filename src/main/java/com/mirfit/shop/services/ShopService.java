package com.mirfit.shop.services;

import com.mirfit.shop.models.CheckRequest;
import com.mirfit.shop.models.Product;
import com.mirfit.shop.repository.ShopRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Service
public class ShopService {

    private static final Random random = new Random();
    private final ShopRepository shopRepository;

    public ShopService(ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
    }

    // Это метод для генерации чека. почитай сообщение про танзакцию,
    // я так и не понял в каком вид рна должны быть.
    // сделай плез базу, я написал метод для взятия всех продуктовЮ но он наверно шлепнется
    public void sendCheck(){

        List<Product> products = generateProducts();
        CheckRequest request;
        if (products != null) {
            request = new CheckRequest(
                    UUID.randomUUID(),
                    countAmount(products),
                    products,
                    LocalDateTime.now(),
                    random.nextBoolean(),
                    "1234567812345678"
                    );
        }
    }

    private List<Product> generateProducts() {

        int numOfProducts = random.nextInt(20) + 1; // 1 - 20
        int[] ids = new int[numOfProducts];

        for (int i = 0; i < numOfProducts; i++) {
            ids[i] = random.nextInt(numOfProducts);
        }

        return shopRepository.getProducts();
    }

    private double countAmount(List<Product> products) {

        Double amount = 0.0;
        for (int i = 0; i < products.size(); i++) {
            amount += products.get(i).getPrice();
        }
        return amount;
    }
}
