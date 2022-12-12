package com.example.catalogservice.vo;

import com.example.catalogservice.entity.CatalogEntity;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import net.bytebuddy.asm.Advice;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
public class ResponseCatalog {
    private String productId;
    private String productName;
    private Integer unitPrice;
    private Integer stock;
    private LocalDateTime createAt;

    @Builder
    public ResponseCatalog(String productId, String productName, Integer unitPrice, Integer stock, LocalDateTime createAt) {
        this.productId = productId;
        this.productName = productName;
        this.unitPrice = unitPrice;
        this.stock = stock;
        this.createAt = createAt;
    }

    public static ResponseCatalog of(CatalogEntity catalogEntity){
        return ResponseCatalog.builder()
                .productId(catalogEntity.getProductId())
                .productName(catalogEntity.getProductName())
                .unitPrice(catalogEntity.getUnitPrice())
                .stock(catalogEntity.getStock())
                .createAt(catalogEntity.getCreateAt())
                .build();
    }
}
