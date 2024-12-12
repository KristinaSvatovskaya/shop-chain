package com.javaacademy.shop_chain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class UpdateGoodPriceDto {
    @NonNull
    private String name;
    @NonNull
    private BigDecimal newPrice;
}
