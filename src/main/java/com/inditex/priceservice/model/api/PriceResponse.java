package com.inditex.priceservice.model.api;

import com.inditex.priceservice.model.dto.PriceDto;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;

@Schema(name = "PriceResponse", description = "Price Response")
public record PriceResponse(
    @NotNull @Schema(description = "Product Identifier.", example = "35455") Integer productId,
    @NotNull @Schema(description = "Brand Identifier.", example = "1") Integer brandId,
    @NotNull @Schema(description = "Rate identifier to apply to the product.", example = "4")
        Integer priceListId,
    @NotNull
        @Schema(
            description = "Start date to apply the product rate.",
            example = "2020-06-15 16:00:00")
        String startDate,
    @NotNull
        @Schema(
            description = "End date to apply the product rate.",
            example = "2020-12-31 23:59:59")
        String endDate,
    @NotNull @Schema(description = "Final price to apply to the product.", example = "38.95")
        BigDecimal price) {

  static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

  public PriceResponse(PriceDto priceDto) {
    this(
        priceDto.productId(),
        priceDto.brandId(),
        priceDto.priceListId(),
        priceDto.startDate().format(formatter),
        priceDto.endDate().format(formatter),
        priceDto.price());
  }
}
