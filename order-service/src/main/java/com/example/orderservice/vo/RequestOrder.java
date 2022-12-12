package com.example.orderservice.vo;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RequestOrder {
    private String productId;
    private Integer quantity;
    private Integer unitPrice;

    public RequestOrder(String productId, Integer quantity, Integer unitPrice) {
        this.productId = productId;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }
}
