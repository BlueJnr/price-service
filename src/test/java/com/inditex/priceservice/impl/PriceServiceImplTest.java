package com.inditex.priceservice.impl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.inditex.priceservice.model.api.PriceResponse;
import com.inditex.priceservice.model.dto.PriceDto;
import com.inditex.priceservice.model.dto.PriceParamDto;
import com.inditex.priceservice.repository.PriceRepository;
import com.inditex.priceservice.service.impl.PriceServiceImpl;
import com.inditex.priceservice.util.DataUtils;
import java.time.LocalDateTime;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class PriceServiceImplTest {
  @Mock private PriceRepository priceRepository;
  @InjectMocks private PriceServiceImpl priceService;

  @Test
  @DisplayName(
      """
          Given A final price list
            For product identifier 35455
            With start and end application dates
            For the brand ZARA

          When The getFinalPrice() method is executed
            With product identifier 35455
            With the application date '2020-06-14 10:00:00'
            And brand identifier 1

          Then Should return final price of the product
            With product identifier 35455
            With the brand identifier ZARA
            With the start of the application date of '2020-06-14 00:00:00'
            And the end of the application date of '2020-12-31 23:59:59'
            with a final price of 35.50
      """)
  void getFinalPriceTest1() {
    Integer productId = 35455;
    LocalDateTime applicationDate = LocalDateTime.parse("2020-06-14 10:00:00", DataUtils.formatter);
    Integer brandId = 1;
    PriceParamDto priceParamDto = new PriceParamDto(productId, applicationDate, brandId);

    List<PriceDto> pricesExpected = List.of(DataUtils.PRICE_DTO_OBJECT_1);

    when(priceRepository.findAllPrices(priceParamDto)).thenReturn(pricesExpected);

    PriceResponse priceResponse = priceService.getFinalPrice(productId, applicationDate, brandId);

    assertEquals(productId, priceResponse.productId());
    assertTrue(
        LocalDateTime.parse(priceResponse.endDate(), DataUtils.formatter).isAfter(applicationDate)
            || LocalDateTime.parse(priceResponse.endDate(), DataUtils.formatter)
                .equals(applicationDate));
    assertTrue(
        LocalDateTime.parse(priceResponse.startDate(), DataUtils.formatter)
                .isBefore(applicationDate)
            || LocalDateTime.parse(priceResponse.startDate(), DataUtils.formatter)
                .equals(applicationDate));
    assertEquals(brandId, priceResponse.brandId());

    verify(priceRepository).findAllPrices(any(PriceParamDto.class));
  }

  @Test
  @DisplayName(
      """
          Given A final price list
            For product identifier 35455
            With start and end application dates
            For the brand ZARA

          When The getFinalPrice() method is executed
            With product identifier 35455
            With the application date '2020-06-14 16:00:00'
            And brand identifier 1

          Then Should return final price of the product
            With product identifier 35455
            With the brand identifier ZARA
            With the start of the application date of '2020-06-14 15:00:00'
            And the end of the application date of '2020-06-14 18:30:00'
            With a final price of 25.45
      """)
  void getFinalPriceTest2() {
    Integer productId = 35455;
    LocalDateTime applicationDate = LocalDateTime.parse("2020-06-14 16:00:00", DataUtils.formatter);
    Integer brandId = 1;
    PriceParamDto priceParamDto = new PriceParamDto(productId, applicationDate, brandId);

    List<PriceDto> pricesExpected =
        List.of(DataUtils.PRICE_DTO_OBJECT_1, DataUtils.PRICE_DTO_OBJECT_2);

    when(priceRepository.findAllPrices(priceParamDto)).thenReturn(pricesExpected);

    PriceResponse priceResponse = priceService.getFinalPrice(productId, applicationDate, brandId);

    assertEquals(productId, priceResponse.productId());
    assertTrue(
        LocalDateTime.parse(priceResponse.endDate(), DataUtils.formatter).isAfter(applicationDate)
            || LocalDateTime.parse(priceResponse.endDate(), DataUtils.formatter)
                .equals(applicationDate));
    assertTrue(
        LocalDateTime.parse(priceResponse.startDate(), DataUtils.formatter)
                .isBefore(applicationDate)
            || LocalDateTime.parse(priceResponse.startDate(), DataUtils.formatter)
                .equals(applicationDate));
    assertEquals(brandId, priceResponse.brandId());

    verify(priceRepository).findAllPrices(any(PriceParamDto.class));
  }

  @Test
  @DisplayName(
      """
          Given A final price list
            For product identifier 35455
            With start and end application dates
            For the brand ZARA

          When The getFinalPrice() method is executed
            With product identifier 35455
            With the application date '2020-06-14 21:00:00'
            And brand identifier 1

          Then Should return final price of the product
            With product identifier 35455
            With the brand identifier ZARA
            With the start of the application date of '2020-06-14 00:00:00'
            And the end of the application date of '2020-12-31 23:59:59'
            With a final price of 35.50
      """)
  void getFinalPriceTest3() {
    Integer productId = 35455;
    LocalDateTime applicationDate = LocalDateTime.parse("2020-06-14 21:00:00", DataUtils.formatter);
    Integer brandId = 1;
    PriceParamDto priceParamDto = new PriceParamDto(productId, applicationDate, brandId);

    List<PriceDto> pricesExpected = List.of(DataUtils.PRICE_DTO_OBJECT_1);

    when(priceRepository.findAllPrices(priceParamDto)).thenReturn(pricesExpected);

    PriceResponse priceResponse = priceService.getFinalPrice(productId, applicationDate, brandId);

    assertEquals(productId, priceResponse.productId());
    assertTrue(
        LocalDateTime.parse(priceResponse.endDate(), DataUtils.formatter).isAfter(applicationDate)
            || LocalDateTime.parse(priceResponse.endDate(), DataUtils.formatter)
                .equals(applicationDate));
    assertTrue(
        LocalDateTime.parse(priceResponse.startDate(), DataUtils.formatter)
                .isBefore(applicationDate)
            || LocalDateTime.parse(priceResponse.startDate(), DataUtils.formatter)
                .equals(applicationDate));
    assertEquals(brandId, priceResponse.brandId());

    verify(priceRepository).findAllPrices(any(PriceParamDto.class));
  }

  @Test
  @DisplayName(
      """
          Given A final price list
            For product identifier 35455
            With start and end application dates
            For the brand ZARA

          When The getFinalPrice() method is executed
            With product identifier 35455
            With the application date '2020-06-15 10:00:00'
            And brand identifier 1

          Then Should return final price of the product
            With product identifier 35455
            With the brand identifier ZARA
            With the start of the application date of '2020-06-15 00:00:00'
            And the end of the application date of '2020-06-15 11:00:00'
            With a final price of 30.50
      """)
  void getFinalPriceTest4() {
    Integer productId = 35455;
    LocalDateTime applicationDate = LocalDateTime.parse("2020-06-15 10:00:00", DataUtils.formatter);
    Integer brandId = 1;
    PriceParamDto priceParamDto = new PriceParamDto(productId, applicationDate, brandId);

    List<PriceDto> pricesExpected =
        List.of(DataUtils.PRICE_DTO_OBJECT_1, DataUtils.PRICE_DTO_OBJECT_3);

    when(priceRepository.findAllPrices(priceParamDto)).thenReturn(pricesExpected);

    PriceResponse priceResponse = priceService.getFinalPrice(productId, applicationDate, brandId);

    assertEquals(productId, priceResponse.productId());
    assertTrue(
        LocalDateTime.parse(priceResponse.endDate(), DataUtils.formatter).isAfter(applicationDate)
            || LocalDateTime.parse(priceResponse.endDate(), DataUtils.formatter)
                .equals(applicationDate));
    assertTrue(
        LocalDateTime.parse(priceResponse.startDate(), DataUtils.formatter)
                .isBefore(applicationDate)
            || LocalDateTime.parse(priceResponse.startDate(), DataUtils.formatter)
                .equals(applicationDate));
    assertEquals(brandId, priceResponse.brandId());

    verify(priceRepository).findAllPrices(any(PriceParamDto.class));
  }

  @Test
  @DisplayName(
      """
          Given A final price list
            For product identifier 35455
            With start and end application dates
            For the brand ZARA

          When The getFinalPrice() method is executed
            With product identifier 35455
            With the application date '2020-06-16 21:00:00'
            And brand identifier 1

          Then Should return final price of the product
            With product identifier 35455
            With the brand identifier ZARA
            With the start of the application date of '2020-06-15 16:00:00'
            And the end of the application date of '2020-12-31 23:59:59'
            With a final price of 38.95
      """)
  void getFinalPriceTest5() {
    Integer productId = 35455;
    LocalDateTime applicationDate = LocalDateTime.parse("2020-06-16 21:00:00", DataUtils.formatter);
    Integer brandId = 1;
    PriceParamDto priceParamDto = new PriceParamDto(productId, applicationDate, brandId);

    List<PriceDto> pricesExpected =
        List.of(DataUtils.PRICE_DTO_OBJECT_1, DataUtils.PRICE_DTO_OBJECT_4);

    when(priceRepository.findAllPrices(priceParamDto)).thenReturn(pricesExpected);

    PriceResponse priceResponse = priceService.getFinalPrice(productId, applicationDate, brandId);

    assertEquals(productId, priceResponse.productId());
    assertTrue(
        LocalDateTime.parse(priceResponse.endDate(), DataUtils.formatter).isAfter(applicationDate)
            || LocalDateTime.parse(priceResponse.endDate(), DataUtils.formatter)
                .equals(applicationDate));
    assertTrue(
        LocalDateTime.parse(priceResponse.startDate(), DataUtils.formatter)
                .isBefore(applicationDate)
            || LocalDateTime.parse(priceResponse.startDate(), DataUtils.formatter)
                .equals(applicationDate));
    assertEquals(brandId, priceResponse.brandId());

    verify(priceRepository).findAllPrices(any(PriceParamDto.class));
  }
}
