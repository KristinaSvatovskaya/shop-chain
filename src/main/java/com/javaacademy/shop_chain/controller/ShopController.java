package com.javaacademy.shop_chain.controller;

import com.javaacademy.shop_chain.dto.GoodDto;
import com.javaacademy.shop_chain.dto.UpdateGoodPriceDto;
import com.javaacademy.shop_chain.service.ShopService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/shop/good")
@RequiredArgsConstructor
@Tag(name = "Shop Operations", description = "Контроллер для работы с магазинами и товарами")
public class ShopController {
    private final ShopService shopService;
    private final RestTemplate restTemplate;

    @GetMapping
    @Operation(tags = "Получение товара по имени", summary = "Получение товара по имени", description = "Метод получает товар по его имени.")
    public GoodDto findGoodByName(@RequestParam String name) {
        return shopService.findByName(name);
    }

    @PatchMapping("/good")
    @Operation(tags = "Изменение цены товара", summary = "Изменение цены товара", description = "Метод обновляет цену товара в магазине.")
    public void updatePrice(@RequestBody UpdateGoodPriceDto dto) {
        shopService.updateGoodPrice(dto);

        restTemplate.patchForObject("http://localhost:8081/shop/good", dto, Void.class);
        restTemplate.patchForObject("http://localhost:8082/shop/good", dto, Void.class);
    }
}
