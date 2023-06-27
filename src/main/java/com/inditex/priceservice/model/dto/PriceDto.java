package com.inditex.priceservice.model.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record PriceDto(
    Integer brandId,
    Integer priceListId,
    Integer productId,
    LocalDateTime startDate,
    LocalDateTime endDate,
    Short priority,
    BigDecimal price) {}
