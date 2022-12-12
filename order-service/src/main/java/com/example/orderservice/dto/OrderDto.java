package com.example.orderservice.dto;

import com.example.orderservice.entity.OrderEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Getter
@NoArgsConstructor
public class OrderDto implements Serializable {

    private String productId;
    private Integer quantity;
    private Integer unitPrice;
    private Integer totalPrice;

    private String orderId;
    private String userId;

    @Builder
    public OrderDto(String productId, Integer quantity, Integer unitPrice, Integer totalPrice, String orderId, String userId) {
        this.productId = productId;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.totalPrice = totalPrice;
        this.orderId = orderId;
        this.userId = userId;
    }


    public static OrderDto of(OrderEntity entity){
        return OrderDto.builder()
                .productId(entity.getProductId())
                .quantity(entity.getQuantity())
                .unitPrice(entity.getUnitPrice())
                .totalPrice(entity.getTotalPrice())
                .userId(entity.getUserId())
                .orderId(entity.getOrderId())
                .build();
    }
}
