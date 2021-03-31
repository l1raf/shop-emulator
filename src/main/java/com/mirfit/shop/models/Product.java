package com.mirfit.shop.models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@JsonAutoDetect
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Product {

    @Id
    @GeneratedValue
    private int id;

    private String name;

    private long price;

    private String currencyCode;

    public Product() {
    }

    public Product(int id, String name, long price, String currencyCode) {
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

    public long getPrice() {
        return price;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }
}
