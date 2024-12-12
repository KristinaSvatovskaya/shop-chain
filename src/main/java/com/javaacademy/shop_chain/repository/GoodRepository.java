package com.javaacademy.shop_chain.repository;

import com.javaacademy.shop_chain.entity.Good;
import com.javaacademy.shop_chain.storage.GoodStorage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class GoodRepository {
    private final GoodStorage goodStorage;

    public Optional<Good> findFirstByName(String name) {
        return Optional.ofNullable(goodStorage.getData().get(name));
    }
}
