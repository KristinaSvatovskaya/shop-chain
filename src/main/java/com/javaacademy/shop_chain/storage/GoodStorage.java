package com.javaacademy.shop_chain.storage;

import com.javaacademy.shop_chain.entity.Good;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Getter
public class GoodStorage {
    private final Map<String, Good> data = new HashMap<>();
}
