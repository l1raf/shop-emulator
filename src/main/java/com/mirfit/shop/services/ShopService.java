package com.mirfit.shop.services;

import com.mirfit.shop.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ShopService {
    String sendCheck();

    List<Product> generateProducts();

    String cancelTransaction(String transactionNumber);
}
