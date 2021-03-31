package com.mirfit.shop.services;

import com.mirfit.shop.models.CheckRequest;
import com.mirfit.shop.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ShopService {
    CheckRequest sendCheck();

    List<Product> generateProducts();
}
