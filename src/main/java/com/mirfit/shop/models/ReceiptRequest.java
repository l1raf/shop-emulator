package com.mirfit.shop.models;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class ReceiptRequest {

    private String transactionNumber;

    private long amount;

    private List<Product> goods;

    private LocalDate localDate;

    private LocalTime localTime;

    private Boolean accrual;

    private String cardSequence;

    // The number of a terminal (1-15)
    private String cardAcceptorIdentificationCode;

    public ReceiptRequest() {
    }

    public ReceiptRequest(String transactionId, long amount,
                          List<Product> goods, LocalDate dateTime,
                          LocalTime localTime, Boolean isAccrual, String cardSequence,
                          String cardAcceptorIdentificationCode) {
        this.transactionNumber = transactionId;
        this.amount = amount;
        this.goods = goods;
        this.localDate = dateTime;
        this.accrual = isAccrual;
        this.localTime = localTime;
        this.cardSequence = cardSequence;
        this.cardAcceptorIdentificationCode = cardAcceptorIdentificationCode;
    }

    public String getTransactionNumber() {
        return transactionNumber;
    }

    public long getAmount() {
        return amount;
    }

    public List<Product> getGoods() {
        return goods;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public Boolean getAccrual() {
        return accrual;
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
