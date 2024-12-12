package com.javaacademy.shop_chain.controller;

import com.javaacademy.shop_chain.dto.GoodDto;
import com.javaacademy.shop_chain.dto.UpdateGoodPriceDto;
import com.javaacademy.shop_chain.service.ShopService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shop/good")
@RequiredArgsConstructor
public class ShopController {
    private final ShopService shopService;

    @GetMapping
    public GoodDto findGoodByName(@RequestParam String name) {
        return shopService.findByName(name);
    }

    @PatchMapping
    public void updatePrice(@RequestBody UpdateGoodPriceDto dto) {
        shopService.updateGoodPrice(dto);
    }
}
