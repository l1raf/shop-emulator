package com.mirfit.shop.repositories;

import com.mirfit.shop.models.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> getProducts();
}
