package com.mirfit.shop.models;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class CheckRequest {

    private UUID transactionId;

    private Double amount;

    private List<Product> goods;

    private LocalDateTime dateTime;

    private Boolean isAccrual;

    private String cardSequence;


    public CheckRequest(UUID transactionId, Double amount,
                        List<Product> goods, LocalDateTime dateTime,
                        Boolean isAccrual, String cardSequence) {
        this.transactionId = transactionId;
        this.amount = amount;
        this.goods = goods;
        this.dateTime = dateTime;
        this.isAccrual = isAccrual;
        this.cardSequence = cardSequence;
    }

    public UUID getTransactionId() {
        return transactionId;
    }

    public Double getAmount() {
        return amount;
    }

    public List<Product> getGoods() {
        return goods;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public Boolean getAccrual() {
        return isAccrual;
    }

    public String getCardSequence() {
        return cardSequence;
    }
}
