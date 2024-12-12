package com.javaacademy.shop_chain.controller;

import com.javaacademy.shop_chain.dto.StatusDto;
import com.javaacademy.shop_chain.service.ShopService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/status")
@RequiredArgsConstructor
public class StatusController {
    private final ShopService service;

    @GetMapping
    public StatusDto getStatus() {
        return service.getStatus();
    }
}
