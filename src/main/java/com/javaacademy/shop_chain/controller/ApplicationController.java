package com.javaacademy.shop_chain.controller;

import com.javaacademy.shop_chain.dto.StatusDto;
import com.javaacademy.shop_chain.service.ShopService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/application")
@RequiredArgsConstructor
@Slf4j
public class ApplicationController {
    private final ShopService service;
    private final ConfigurableApplicationContext context;

    @GetMapping("/status")
    public StatusDto getStatus() {
        return service.getStatus();
    }

    @PostMapping("/shutdown")
    public void shutdown() {
        log.info("Приложение выключается");
        SpringApplication.exit(context);
    }
}
