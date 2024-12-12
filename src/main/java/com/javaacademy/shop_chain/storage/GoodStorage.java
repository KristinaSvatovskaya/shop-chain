package com.javaacademy.shop_chain.storage;

import com.javaacademy.shop_chain.entity.Good;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Component
@Getter
public class GoodStorage {
    public static final String BREAD = "хлеб";
    private final Map<String, Good> data = new HashMap<>();
    @Value("${shop.bread.price}")
    private BigDecimal breadPrice;

    @PostConstruct
    public void init() {
        data.put(BREAD, new Good(BREAD, breadPrice));
    }
}
