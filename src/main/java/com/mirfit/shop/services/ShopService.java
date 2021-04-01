package com.mirfit.shop.services;

import com.mirfit.shop.models.ReceiptRequest;
import com.mirfit.shop.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ShopService {
    double sendCheck();

    List<Product> generateProducts();
}
