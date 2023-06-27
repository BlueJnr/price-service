package com.inditex.priceservice.service;

import com.inditex.priceservice.model.api.PriceResponse;
import java.time.LocalDateTime;

public interface PriceService {
  PriceResponse getFinalPrice(Integer productId, LocalDateTime applicationDate, Integer brandId);
}
