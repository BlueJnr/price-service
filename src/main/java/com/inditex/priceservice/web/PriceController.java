package com.inditex.priceservice.web;

import com.inditex.priceservice.model.api.PriceResponse;
import com.inditex.priceservice.service.PriceService;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/prices")
@RequiredArgsConstructor
public class PriceController implements PriceApi {
  private final PriceService priceService;

  @Override
  @GetMapping(
      value = "/{productId}",
      produces = MediaType.APPLICATION_JSON_VALUE,
      consumes = MediaType.APPLICATION_JSON_VALUE)
  public PriceResponse getPrice(
      @PathVariable Integer productId,
      @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime applicationDate,
      @RequestParam Integer brandId) {
    return priceService.getFinalPrice(productId, applicationDate, brandId);
  }
}
