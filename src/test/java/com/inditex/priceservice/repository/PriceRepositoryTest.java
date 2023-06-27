package com.inditex.priceservice.repository;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.lessThanOrEqualTo;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.inditex.priceservice.model.dto.PriceDto;
import com.inditex.priceservice.model.dto.PriceParamDto;
import com.inditex.priceservice.util.DataUtils;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@DataJpaTest
@ExtendWith(SpringExtension.class)
class PriceRepositoryTest {
  @Autowired private PriceRepository priceRepository;

  @Test
  @DisplayName(
      """
          Given The final price records
            For product identifier 35455
            With start and end application dates
            For the brand ZARA

          When The findAllPrices() method is executed
            With product identifier 35455
            With the application date '2020-06-14 10:00:00'
            And brand identifier 1

          Then Should return a record
            With product identifier 35455
            With the brand identifier 1
            With the start of the application date of '2020-06-14 00:00:00'
            And the end of the application date of '2020-12-31 23:59:59'
      """)
  void findAllPricesTest1() {
    Integer productId = 35455;
    LocalDateTime applicationDate = LocalDateTime.parse("2020-06-14 10:00:00", DataUtils.formatter);
    Integer brandId = 1;
    PriceParamDto priceParamDto = new PriceParamDto(productId, applicationDate, brandId);

    List<PriceDto> pricesExpected = List.of(DataUtils.PRICE_DTO_OBJECT_1);

    final List<PriceDto> pricesActual = priceRepository.findAllPrices(priceParamDto);

    assertNotNull(pricesActual);
    assertFalse(pricesActual.isEmpty());
    assertThat(pricesActual, is(pricesExpected));
    assertThat(pricesActual, not((sameInstance(pricesExpected))));
    assertThat(pricesActual, hasSize(1));
    assertThat(pricesActual, instanceOf(List.class));
    assertThat(
        pricesActual.stream().map(PriceDto::productId).collect(Collectors.toList()),
        everyItem(equalTo(productId)));
    assertThat(
        pricesActual.stream().map(PriceDto::brandId).collect(Collectors.toList()),
        everyItem(equalTo(brandId)));
    assertThat(
        pricesActual.stream().map(PriceDto::startDate).collect(Collectors.toList()),
        everyItem(lessThanOrEqualTo(applicationDate)));
    assertThat(
        pricesActual.stream().map(PriceDto::endDate).collect(Collectors.toList()),
        everyItem(greaterThanOrEqualTo(applicationDate)));
  }

  @Test
  @DisplayName(
      """
          Given The final price records
            For product identifier 35455
            With start and end application dates
            For the brand ZARA

          When The findAllPrices() method is executed
            With product identifier 35455
            With the application date '2020-06-14 16:00:00'
            And brand identifier 1

          Then Should return two records
            With product identifier 35455
            With the brand identifier 1
            With the start of the application date of '2020-06-14 15:00:00'
            And the end of the application date of '2020-06-14 18:30:00'
      """)
  void findAllPricesTest2() {
    Integer productId = 35455;
    LocalDateTime applicationDate = LocalDateTime.parse("2020-06-14 16:00:00", DataUtils.formatter);
    Integer brandId = 1;
    PriceParamDto priceParamDto = new PriceParamDto(productId, applicationDate, brandId);

    List<PriceDto> pricesExpected =
        List.of(DataUtils.PRICE_DTO_OBJECT_1, DataUtils.PRICE_DTO_OBJECT_2);

    final List<PriceDto> pricesActual = priceRepository.findAllPrices(priceParamDto);

    assertNotNull(pricesActual);
    assertFalse(pricesActual.isEmpty());
    assertThat(pricesActual, is(pricesExpected));
    assertThat(pricesActual, not((sameInstance(pricesExpected))));
    assertThat(pricesActual, hasSize(2));
    assertThat(pricesActual, instanceOf(List.class));
    assertThat(
        pricesActual.stream().map(PriceDto::productId).collect(Collectors.toList()),
        everyItem(equalTo(productId)));
    assertThat(
        pricesActual.stream().map(PriceDto::brandId).collect(Collectors.toList()),
        everyItem(equalTo(brandId)));
    assertThat(
        pricesActual.stream().map(PriceDto::startDate).collect(Collectors.toList()),
        everyItem(lessThanOrEqualTo(applicationDate)));
    assertThat(
        pricesActual.stream().map(PriceDto::endDate).collect(Collectors.toList()),
        everyItem(greaterThanOrEqualTo(applicationDate)));
  }

  @Test
  @DisplayName(
      """
          Given The final price records
            For product identifier 35455
            With start and end application dates
            For the brand ZARA

          When The findAllPrices() method is executed
            With product identifier 35455
            With the application date '2020-06-14 21:00:00'
            And brand identifier 1

          Then Should return a record
            With product identifier 35455
            With the brand identifier 1
            With the start of the application date of '2020-06-14 00:00:00'
            And the end of the application date of '2020-12-31 23:59:59'
      """)
  void findAllPricesTest3() {
    Integer productId = 35455;
    LocalDateTime applicationDate = LocalDateTime.parse("2020-06-14 21:00:00", DataUtils.formatter);
    Integer brandId = 1;
    PriceParamDto priceParamDto = new PriceParamDto(productId, applicationDate, brandId);

    List<PriceDto> pricesExpected = List.of(DataUtils.PRICE_DTO_OBJECT_1);

    final List<PriceDto> pricesActual = priceRepository.findAllPrices(priceParamDto);

    assertNotNull(pricesActual);
    assertFalse(pricesActual.isEmpty());
    assertThat(pricesActual, is(pricesExpected));
    assertThat(pricesActual, not((sameInstance(pricesExpected))));
    assertThat(pricesActual, hasSize(1));
    assertThat(pricesActual, instanceOf(List.class));
    assertThat(
        pricesActual.stream().map(PriceDto::productId).collect(Collectors.toList()),
        everyItem(equalTo(productId)));
    assertThat(
        pricesActual.stream().map(PriceDto::brandId).collect(Collectors.toList()),
        everyItem(equalTo(brandId)));
    assertThat(
        pricesActual.stream().map(PriceDto::startDate).collect(Collectors.toList()),
        everyItem(lessThanOrEqualTo(applicationDate)));
    assertThat(
        pricesActual.stream().map(PriceDto::endDate).collect(Collectors.toList()),
        everyItem(greaterThanOrEqualTo(applicationDate)));
  }

  @Test
  @DisplayName(
      """
              Given The final price records
                For product identifier 35455
                With start and end application dates
                For the brand ZARA

              When The findAllPrices() method is executed
                With product identifier 35455
                With the application date '2020-06-15 10:00:00'
                And brand identifier 1

              Then Should return two records
                With product identifier 35455
                With the brand identifier 1
                With the start of the application date of '2020-06-15 00:00:00'
                And the end of the application date of '2020-06-15 11:00:00'
          """)
  void findAllPricesTest4() {
    Integer productId = 35455;
    LocalDateTime applicationDate = LocalDateTime.parse("2020-06-15 10:00:00", DataUtils.formatter);
    Integer brandId = 1;
    PriceParamDto priceParamDto = new PriceParamDto(productId, applicationDate, brandId);

    List<PriceDto> pricesExpected =
        List.of(DataUtils.PRICE_DTO_OBJECT_1, DataUtils.PRICE_DTO_OBJECT_3);

    final List<PriceDto> pricesActual = priceRepository.findAllPrices(priceParamDto);

    assertNotNull(pricesActual);
    assertFalse(pricesActual.isEmpty());
    assertThat(pricesActual, is(pricesExpected));
    assertThat(pricesActual, not((sameInstance(pricesExpected))));
    assertThat(pricesActual, hasSize(2));
    assertThat(pricesActual, instanceOf(List.class));
    assertThat(
        pricesActual.stream().map(PriceDto::productId).collect(Collectors.toList()),
        everyItem(equalTo(productId)));
    assertThat(
        pricesActual.stream().map(PriceDto::brandId).collect(Collectors.toList()),
        everyItem(equalTo(brandId)));
    assertThat(
        pricesActual.stream().map(PriceDto::startDate).collect(Collectors.toList()),
        everyItem(lessThanOrEqualTo(applicationDate)));
    assertThat(
        pricesActual.stream().map(PriceDto::endDate).collect(Collectors.toList()),
        everyItem(greaterThanOrEqualTo(applicationDate)));
  }

  @Test
  @DisplayName(
      """
                  Given The final price records
                    For product identifier 35455
                    With start and end application dates
                    For the brand ZARA

                  When The findAllPrices() method is executed
                    With product identifier 35455
                    With the application date '2020-06-16 21:00:00'
                    And brand identifier 1

                  Then Should return two records
                    With product identifier 35455
                    With the brand identifier 1
                    With the start of the application date of '2020-06-15 16:00:00'
                    And the end of the application date of '2020-12-31 23:59:59'
              """)
  void findAllPricesTest5() {
    Integer productId = 35455;
    LocalDateTime applicationDate = LocalDateTime.parse("2020-06-16 21:00:00", DataUtils.formatter);
    Integer brandId = 1;
    PriceParamDto priceParamDto = new PriceParamDto(productId, applicationDate, brandId);

    List<PriceDto> pricesExpected =
        List.of(DataUtils.PRICE_DTO_OBJECT_1, DataUtils.PRICE_DTO_OBJECT_4);

    final List<PriceDto> pricesActual = priceRepository.findAllPrices(priceParamDto);

    assertNotNull(pricesActual);
    assertFalse(pricesActual.isEmpty());
    assertThat(pricesActual, is(pricesExpected));
    assertThat(pricesActual, not((sameInstance(pricesExpected))));
    assertThat(pricesActual, hasSize(2));
    assertThat(pricesActual, instanceOf(List.class));
    assertThat(
        pricesActual.stream().map(PriceDto::productId).collect(Collectors.toList()),
        everyItem(equalTo(productId)));
    assertThat(
        pricesActual.stream().map(PriceDto::brandId).collect(Collectors.toList()),
        everyItem(equalTo(brandId)));
    assertThat(
        pricesActual.stream().map(PriceDto::startDate).collect(Collectors.toList()),
        everyItem(lessThanOrEqualTo(applicationDate)));
    assertThat(
        pricesActual.stream().map(PriceDto::endDate).collect(Collectors.toList()),
        everyItem(greaterThanOrEqualTo(applicationDate)));
  }
}
