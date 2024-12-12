package com.javaacademy.shop_chain.service;

import com.javaacademy.shop_chain.dto.GoodDto;
import com.javaacademy.shop_chain.dto.StatusDto;
import com.javaacademy.shop_chain.dto.UpdateGoodPriceDto;

public interface ShopService {

    StatusDto getStatus();

    void updateGoodPrice(UpdateGoodPriceDto dto);

    GoodDto findByName(String name);
}
