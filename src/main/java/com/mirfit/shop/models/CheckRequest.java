package com.mirfit.shop.models;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class CheckRequest {

    private String transactionId;

    private Double amount;

    private List<Product> goods;

    private LocalDate localDate;

    private LocalTime localTime;

    private Boolean isAccrual;

    private String cardSequence;

    public CheckRequest() {
    }

    public CheckRequest(String transactionId, Double amount,
                        List<Product> goods, LocalDate dateTime,
                        LocalTime localTime, Boolean isAccrual, String cardSequence) {
        this.transactionId = transactionId;
        this.amount = amount;
        this.goods = goods;
        this.localDate = dateTime;
        this.isAccrual = isAccrual;
        this.localTime = localTime;
        this.cardSequence = cardSequence;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public Double getAmount() {
        return amount;
    }

    public List<Product> getGoods() {
        return goods;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public Boolean getAccrual() {
        return isAccrual;
    }

    public String getCardSequence() {
        return cardSequence;
    }
}
