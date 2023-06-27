package com.inditex.priceservice.config.exception;

import java.time.LocalDateTime;

public class PriceNotFoundException extends RuntimeException {

  public PriceNotFoundException(Integer productId, LocalDateTime applicationDate, Integer brandId) {
    super(
        "Price with productId: "
            + productId
            + ", applicationDate: "
            + applicationDate.toString()
            + ", brandId: "
            + brandId
            + " not found");
  }
}
