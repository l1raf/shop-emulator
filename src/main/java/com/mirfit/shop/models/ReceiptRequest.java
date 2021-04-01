package com.mirfit.shop.models;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class ReceiptRequest {

    private String transactionId;

    private int amount;

    private List<Product> goods;

    private LocalDate localDate;

    private LocalTime localTime;

    private Boolean isAccrual;

    private String cardSequence;

    // The number of a terminal (1-15)
    private String cardAcceptorIdentificationCode;

    public ReceiptRequest() {
    }

    public ReceiptRequest(String transactionId, int amount,
                          List<Product> goods, LocalDate dateTime,
                          LocalTime localTime, Boolean isAccrual, String cardSequence,
                          String cardAcceptorIdentificationCode) {
        this.transactionId = transactionId;
        this.amount = amount;
        this.goods = goods;
        this.localDate = dateTime;
        this.isAccrual = isAccrual;
        this.localTime = localTime;
        this.cardSequence = cardSequence;
        this.cardAcceptorIdentificationCode = cardAcceptorIdentificationCode;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public int getAmount() {
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

    public LocalTime getLocalTime() {
        return localTime;
    }

    public String getCardAcceptorIdentificationCode() {
        return cardAcceptorIdentificationCode;
    }
}
