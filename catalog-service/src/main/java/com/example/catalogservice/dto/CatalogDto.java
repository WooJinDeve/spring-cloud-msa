package com.example.catalogservice.dto;

import com.example.catalogservice.entity.CatalogEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import java.io.Serializable;

@Getter
@NoArgsConstructor
public class CatalogDto implements Serializable {

    private String productId;
    private Integer quantity;
    private Integer unitPrice;
    private Integer totalPrice;

    private String orderId;
    private String userId;

    @Builder
    public CatalogDto(String productId, Integer quantity, Integer unitPrice, Integer totalPrice, String orderId, String userId) {
        this.productId = productId;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.totalPrice = totalPrice;
        this.orderId = orderId;
        this.userId = userId;
    }


//    public static CatalogDto of(CatalogEntity catalogEntity){
//        return CatalogDto.builder()
//                .productId(catalogEntity.getProductId())
//                .unitPrice(catalogEntity.getUnitPrice())
//                .build();
//    }
}
