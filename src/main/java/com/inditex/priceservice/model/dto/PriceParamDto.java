package com.inditex.priceservice.model.dto;

import java.time.LocalDateTime;

public record PriceParamDto(Integer productId, LocalDateTime applicationDate, Integer brandId) {}
