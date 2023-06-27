package com.inditex.priceservice.util;

import com.inditex.priceservice.model.api.PriceResponse;
import com.inditex.priceservice.model.dto.PriceDto;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DataUtils {
  public static final DateTimeFormatter formatter =
      DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
  public static final PriceResponse PRICE_RESPONSE_OBJECT_1 =
      new PriceResponse(
          35455, 1, 1, "2020-06-14 00:00:00", "2020-12-31 23:59:59", BigDecimal.valueOf(35.50));
  public static final PriceResponse PRICE_RESPONSE_OBJECT_2 =
      new PriceResponse(
          35455, 1, 2, "2020-06-14 15:00:00", "2020-06-14 18:30:00", BigDecimal.valueOf(25.45));

  public static final PriceResponse PRICE_RESPONSE_OBJECT_3 =
      new PriceResponse(
          35455, 1, 3, "2020-06-15 00:00:00", "2020-06-15 11:00:00", BigDecimal.valueOf(30.50));

  public static final PriceResponse PRICE_RESPONSE_OBJECT_4 =
      new PriceResponse(
          35455, 1, 4, "2020-06-15 16:00:00", "2020-12-31 23:59:59", BigDecimal.valueOf(38.95));

  public static final PriceDto PRICE_DTO_OBJECT_1 =
      new PriceDto(
          1,
          1,
          35455,
          LocalDateTime.parse("2020-06-14 00:00:00", formatter),
          LocalDateTime.parse("2020-12-31 23:59:59", formatter),
          Short.valueOf("0"),
          new BigDecimal("35.50"));
  public static final PriceDto PRICE_DTO_OBJECT_2 =
      new PriceDto(
          1,
          2,
          35455,
          LocalDateTime.parse("2020-06-14 15:00:00", formatter),
          LocalDateTime.parse("2020-06-14 18:30:00", formatter),
          Short.valueOf("1"),
          BigDecimal.valueOf(25.45));

  public static final PriceDto PRICE_DTO_OBJECT_3 =
      new PriceDto(
          1,
          3,
          35455,
          LocalDateTime.parse("2020-06-15 00:00:00", formatter),
          LocalDateTime.parse("2020-06-15 11:00:00", formatter),
          Short.valueOf("1"),
          new BigDecimal("30.50"));

  public static final PriceDto PRICE_DTO_OBJECT_4 =
      new PriceDto(
          1,
          4,
          35455,
          LocalDateTime.parse("2020-06-15 16:00:00", formatter),
          LocalDateTime.parse("2020-12-31 23:59:59", formatter),
          Short.valueOf("1"),
          BigDecimal.valueOf(38.95));
}
