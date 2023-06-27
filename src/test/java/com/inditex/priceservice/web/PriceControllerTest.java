package com.inditex.priceservice.web;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import com.inditex.priceservice.service.PriceService;
import com.inditex.priceservice.util.DataUtils;
import java.time.LocalDateTime;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@ExtendWith(MockitoExtension.class)
class PriceControllerTest {
  @Mock private PriceService priceService;
  @InjectMocks private PriceController priceController;
  private MockMvc mockMvc;

  @BeforeEach
  public void setUp() {
    mockMvc = standaloneSetup(priceController).build();
  }

  @Test
  @DisplayName(
      """
          Given A final price list
            For product identifier 35455
            With start and end application dates
            For the brand ZARA

          When I make the request is made at 10:00 on June 14, 2020
            For product 35455
            For the ZARA brand

          Then I should get the final price of the product
            With product identifier 35455
            With the brand identifier ZARA
            With the identifier 1 of the rate to be applied
            With the start of the application date of '2020-06-14 00:00:00'
            And the end of the application date of '2020-12-31 23:59:59'
            with a final price of 35.50
      """)
  void getPriceTest1() throws Exception {
    String productId = "35455";
    String applicationDate = "2020-06-14 10:00:00";
    String brandId = "1";

    when(priceService.getFinalPrice(anyInt(), any(LocalDateTime.class), anyInt()))
        .thenReturn(DataUtils.PRICE_RESPONSE_OBJECT_1);

    ResultActions result =
        mockMvc.perform(
            MockMvcRequestBuilders.get("/api/prices/" + productId)
                .contentType(MediaType.APPLICATION_JSON)
                .param("applicationDate", applicationDate)
                .param("brandId", brandId));

    result
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(
            content()
                .json(
                    """
                              {
                                  "productId": 35455,
                                  "brandId": 1,
                                  "priceListId": 1,
                                  "startDate": "2020-06-14 00:00:00",
                                  "endDate": "2020-12-31 23:59:59",
                                  "price": 35.50
                              }
                              """));

    verify(priceService).getFinalPrice(anyInt(), any(LocalDateTime.class), anyInt());
  }

  @Test
  @DisplayName(
      """
          Given A final price list
            For product identifier 35455
            With start and end application dates
            For the brand ZARA

          When I make the request is made at 16:00 on June 14, 2020
            For product 35455
            For the ZARA brand

          Then should get response
            With product identifier 35455
            With the brand identifier ZARA
            With the identifier 2 of the rate to be applied
            With the start of the application date of '2020-06-14 15:00:00'
            And the end of the application date of '2020-06-14 18:30:00'
            With a final price of 25.45
      """)
  void getPriceTest2() throws Exception {
    String productId = "35455";
    String applicationDate = "2020-06-14 16:00:00";
    String brandId = "1";

    when(priceService.getFinalPrice(anyInt(), any(LocalDateTime.class), anyInt()))
        .thenReturn(DataUtils.PRICE_RESPONSE_OBJECT_2);

    ResultActions result =
        mockMvc.perform(
            MockMvcRequestBuilders.get("/api/prices/" + productId)
                .contentType(MediaType.APPLICATION_JSON)
                .param("applicationDate", applicationDate)
                .param("brandId", brandId));

    result
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(
            content()
                .json(
                    """
                              {
                                  "productId": 35455,
                                  "brandId": 1,
                                  "priceListId": 2,
                                  "startDate": "2020-06-14 15:00:00",
                                  "endDate": "2020-06-14 18:30:00",
                                  "price": 25.45
                              }
                              """));

    verify(priceService).getFinalPrice(anyInt(), any(LocalDateTime.class), anyInt());
  }

  @Test
  @DisplayName(
      """
          Given A final price list
            For product identifier 35455
            With start and end application dates
            For the brand ZARA

          When I make the request is made at 21:00 on June 14, 2020
            For product 35455
            For the ZARA brand

          Then should get response
            With product identifier 35455
            With the brand identifier ZARA
            With the identifier 1 of the rate to be applied
            With the start of the application date of '2020-06-14 00:00:00'
            And the end of the application date of '2020-12-31 23:59:59'
            With a final price of 35.50
      """)
  void getPriceTest3() throws Exception {
    String productId = "35455";
    String applicationDate = "2020-06-14 21:00:00";
    String brandId = "1";

    when(priceService.getFinalPrice(anyInt(), any(LocalDateTime.class), anyInt()))
        .thenReturn(DataUtils.PRICE_RESPONSE_OBJECT_1);

    ResultActions result =
        mockMvc.perform(
            MockMvcRequestBuilders.get("/api/prices/" + productId)
                .contentType(MediaType.APPLICATION_JSON)
                .param("applicationDate", applicationDate)
                .param("brandId", brandId));

    result
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(
            content()
                .json(
                    """
                              {
                                  "productId": 35455,
                                  "brandId": 1,
                                  "priceListId": 1,
                                  "startDate": "2020-06-14 00:00:00",
                                  "endDate": "2020-12-31 23:59:59",
                                  "price": 35.50
                              }
                              """));

    verify(priceService).getFinalPrice(anyInt(), any(LocalDateTime.class), anyInt());
  }

  @Test
  @DisplayName(
      """
          Given A final price list
            For product identifier 35455
            With start and end application dates
            For the brand ZARA

          When I make the request is made at 10:00 on June 15, 2020
            For product 35455
            For the ZARA brand

          Then should get response
            With product identifier 35455
            With the brand identifier ZARA
            With the identifier 3 of the rate to be applied
            With the start of the application date of '2020-06-15 00:00:00'
            And the end of the application date of '2020-06-15 11:00:00'
            With a final price of 30.50
      """)
  void getPriceTest4() throws Exception {
    String productId = "35455";
    String applicationDate = "2020-06-15 10:00:00";
    String brandId = "1";

    when(priceService.getFinalPrice(anyInt(), any(LocalDateTime.class), anyInt()))
        .thenReturn(DataUtils.PRICE_RESPONSE_OBJECT_3);

    ResultActions result =
        mockMvc.perform(
            MockMvcRequestBuilders.get("/api/prices/" + productId)
                .contentType(MediaType.APPLICATION_JSON)
                .param("applicationDate", applicationDate)
                .param("brandId", brandId));

    result
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(
            content()
                .json(
                    """
                              {
                                  "productId": 35455,
                                  "brandId": 1,
                                  "priceListId": 3,
                                  "startDate": "2020-06-15 00:00:00",
                                  "endDate": "2020-06-15 11:00:00",
                                  "price": 30.50
                              }
                              """));

    verify(priceService).getFinalPrice(anyInt(), any(LocalDateTime.class), anyInt());
  }

  @Test
  @DisplayName(
      """
          Given A final price list
            For product identifier 35455
            With start and end application dates
            For the brand ZARA

          When I make the request is made at 21:00 on June 16, 2020
            For product 35455
            For the ZARA brand

          Then should get response
            With product identifier 35455
            With the brand identifier ZARA
            With the identifier 4 of the rate to be applied
            With the start of the application date of '2020-06-15 16:00:00'
            And the end of the application date of '2020-12-31 23:59:59'
            With a final price of 38.95
      """)
  void getPriceTest5() throws Exception {
    String productId = "35455";
    String applicationDate = "2020-06-16 21:00:00";
    String brandId = "1";

    when(priceService.getFinalPrice(anyInt(), any(LocalDateTime.class), anyInt()))
        .thenReturn(DataUtils.PRICE_RESPONSE_OBJECT_4);

    ResultActions result =
        mockMvc.perform(
            MockMvcRequestBuilders.get("/api/prices/" + productId)
                .contentType(MediaType.APPLICATION_JSON)
                .param("applicationDate", applicationDate)
                .param("brandId", brandId));

    result
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(
            content()
                .json(
                    """
                              {
                                  "productId": 35455,
                                  "brandId": 1,
                                  "priceListId": 4,
                                  "startDate": "2020-06-15 16:00:00",
                                  "endDate": "2020-12-31 23:59:59",
                                  "price": 38.95
                              }
                              """));

    verify(priceService).getFinalPrice(anyInt(), any(LocalDateTime.class), anyInt());
  }
}
