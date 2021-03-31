package com.mirfit.shop.models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@JsonAutoDetect
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Product {

    @Id
    @GeneratedValue
    private int id;

    private String name;

    private Double price;

    private String currencyCode;

    public Product() {}

    public Product(int id, String name, Double price, String currencyCode) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.currencyCode = currencyCode;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }
}
