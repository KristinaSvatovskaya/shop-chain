package com.javaacademy.shop_chain.mapper;

import com.javaacademy.shop_chain.dto.GoodDto;
import com.javaacademy.shop_chain.entity.Good;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface GoodMapper {
    GoodDto convertToDto(Good entity);
}
