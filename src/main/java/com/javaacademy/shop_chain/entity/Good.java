package com.javaacademy.shop_chain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
public class Good {
    @EqualsAndHashCode.Include
    private String name;
    private BigDecimal price;
}
