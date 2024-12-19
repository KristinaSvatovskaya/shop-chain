package com.javaacademy.shop_chain.controller;

import com.javaacademy.shop_chain.dto.StatusDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/shop")
@RequiredArgsConstructor
@Tag(name = "Shop Status", description = "Контроллер для работы с состоянием магазинов")
public class ShopStatusController {
    private final RestTemplate restTemplate;

    @GetMapping("/status")
    @Operation(tags = "Получение статуса всех магазинова",summary = "Получение статуса всех магазинов", description = "Метод получает список статусов всех магазинов.")
    public List<StatusDto> getShopsStatus() {
        StatusDto shop1Status = restTemplate.getForObject("http://localhost:8081/application/status", StatusDto.class);
        StatusDto shop2Status = restTemplate.getForObject("http://localhost:8082/application/status", StatusDto.class);

        return List.of(shop1Status, shop2Status);
    }
}
