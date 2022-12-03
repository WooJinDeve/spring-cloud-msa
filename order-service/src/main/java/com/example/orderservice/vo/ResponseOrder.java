package com.example.orderservice.vo;

import com.example.orderservice.entity.OrderEntity;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
public class ResponseOrder {
    private String productId;
    private Integer quantity;
    private Integer unitPrice;
    private Integer totalPrice;
    private String orderId;
    private LocalDateTime createAt;

    @Builder
    public ResponseOrder(String productId, Integer quantity, Integer unitPrice, Integer totalPrice, String orderId, LocalDateTime createAt) {
        this.productId = productId;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.totalPrice = totalPrice;
        this.orderId = orderId;
        this.createAt = createAt;
    }


    public static ResponseOrder of(OrderEntity entity){
        return ResponseOrder.builder()
                .orderId(entity.getOrderId())
                .productId(entity.getProductId())
                .quantity(entity.getQuantity())
                .unitPrice(entity.getUnitPrice())
                .totalPrice(entity.getTotalPrice())
                .createAt(entity.getCreateAt())
                .build();
    }
}
