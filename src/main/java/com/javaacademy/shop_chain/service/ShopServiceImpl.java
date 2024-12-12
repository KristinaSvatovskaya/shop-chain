package com.javaacademy.shop_chain.service;

import com.javaacademy.shop_chain.dto.GoodDto;
import com.javaacademy.shop_chain.dto.ShopStatus;
import com.javaacademy.shop_chain.dto.StatusDto;
import com.javaacademy.shop_chain.dto.UpdateGoodPriceDto;
import com.javaacademy.shop_chain.entity.Good;
import com.javaacademy.shop_chain.mapper.GoodMapper;
import com.javaacademy.shop_chain.repository.GoodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import static com.javaacademy.shop_chain.dto.ShopStatus.CLOSED;
import static com.javaacademy.shop_chain.dto.ShopStatus.WORK;
import static java.time.LocalTime.parse;
import static java.time.format.DateTimeFormatter.ofPattern;

@Service
@RequiredArgsConstructor
public class ShopServiceImpl implements ShopService {
    private final GoodRepository goodRepository;
    private final GoodMapper goodMapper;
    @Value("${shop.name}")
    private String shopName;
    @Value("${shop.time-open}")
    private String shopTimeOpen;
    @Value("${shop.time-close}")
    private String shopTimeClose;

    @Override
    public void updateGoodPrice(UpdateGoodPriceDto dto) {
        Good good = goodRepository.findFirstByName(dto.getName().toLowerCase(Locale.ROOT)).orElseThrow();
        good.setPrice(dto.getNewPrice());
    }

    @Override
    public GoodDto findByName(String name) {
        return goodRepository.findFirstByName(name.toLowerCase(Locale.ROOT)).map(goodMapper::convertToDto).orElseThrow();
    }

    @Override
    public StatusDto getStatus() {
        return StatusDto.builder()
                .name(shopName)
                .shopStatus(isWorkedNow())
                .timeOpen(shopTimeOpen)
                .timeClose(shopTimeClose)
                .build();
    }

    private ShopStatus isWorkedNow() {
        LocalTime now = LocalTime.now();
        DateTimeFormatter timeFormatter = ofPattern("H:mm");
        LocalTime openTime = parse(shopTimeOpen, timeFormatter);
        LocalTime closeTime = parse(shopTimeClose, timeFormatter);
        return now.isAfter(openTime) && now.isBefore(closeTime)
                ? WORK
                : CLOSED;
    }
}
