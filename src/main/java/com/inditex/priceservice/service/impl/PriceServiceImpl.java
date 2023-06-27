package com.inditex.priceservice.service.impl;

import static java.util.stream.Collectors.groupingBy;

import com.inditex.priceservice.config.exception.MultiplePricesFoundException;
import com.inditex.priceservice.config.exception.PriceNotFoundException;
import com.inditex.priceservice.model.api.PriceResponse;
import com.inditex.priceservice.model.dto.PriceDto;
import com.inditex.priceservice.model.dto.PriceParamDto;
import com.inditex.priceservice.repository.PriceRepository;
import com.inditex.priceservice.service.PriceService;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PriceServiceImpl implements PriceService {
  private final PriceRepository priceRepository;

  @Override
  public PriceResponse getFinalPrice(
      Integer productId, LocalDateTime applicationDate, Integer brandId) {
    return Optional.of(new PriceParamDto(productId, applicationDate, brandId))
        .map(priceRepository::findAllPrices)
        .filter(prices -> !prices.isEmpty())
        .map(PriceServiceImpl::getOnePrice)
        .orElseThrow(() -> new PriceNotFoundException(productId, applicationDate, brandId));
  }

  private static PriceResponse getOnePrice(List<PriceDto> prices) {
    return prices.stream().collect(groupingBy(PriceDto::priority)).entrySet().stream()
        .max(Map.Entry.comparingByKey())
        .map(Map.Entry::getValue)
        .filter(priceEntities -> priceEntities.size() == 1)
        .flatMap(priceEntities -> priceEntities.stream().findFirst())
        .map(PriceResponse::new)
        .orElseThrow(MultiplePricesFoundException::new);
  }
}
