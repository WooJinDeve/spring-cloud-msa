package com.example.userservice.vo;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ResponseOrder {

    private String productId;
    private Integer quantity;
    private Integer unitPrice;
    private Integer totalPrice;
    private LocalDateTime createAt;
    private String orderId;

    public ResponseOrder(String productId, Integer quantity, Integer unitPrice, Integer totalPrice, LocalDateTime createAt, String orderId) {
        this.productId = productId;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.totalPrice = totalPrice;
        this.createAt = createAt;
        this.orderId = orderId;
    }
}
