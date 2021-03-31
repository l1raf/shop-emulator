package com.mirfit.shop.repository;

import com.mirfit.shop.models.Product;

import java.util.List;

public interface ShopRepository {

    List<Product> getProducts();

}
