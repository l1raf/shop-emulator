package com.mirfit.shop.controllers;

import com.mirfit.shop.models.ReceiptRequest;
import com.mirfit.shop.models.Product;
import com.mirfit.shop.services.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/shop")
public class ShopController {

    private final ShopService shopService;

    @Autowired
    public ShopController(ShopService shopService) {
        this.shopService = shopService;
    }

    @GetMapping("check")
    public ResponseEntity<String> getCheck() {
        return new ResponseEntity<>(shopService.sendCheck(), HttpStatus.OK);
    }

    @GetMapping("products")
    public ResponseEntity<List<Product>> getRandomProducts() {
        return new ResponseEntity<>(shopService.generateProducts(), HttpStatus.OK);
    }

    @GetMapping("cancel")
    public ResponseEntity<String> cancel(String transactionNumber) {
        return null;
    }
}
