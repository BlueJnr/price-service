package com.inditex.priceservice.web;

import com.inditex.priceservice.config.GlobalExceptionHandler;
import com.inditex.priceservice.model.api.PriceResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.time.LocalDateTime;

@Tag(name = "prices", description = "Operations between product prices")
public interface PriceApi {

  @Operation(
      tags = {"prices"},
      summary = "Get final price",
      description = "Get final price applied to the product",
      operationId = "getPrice",
      responses = {
        @ApiResponse(
            responseCode = "200",
            description = "Success",
            content =
                @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = PriceResponse.class))),
        @ApiResponse(
            responseCode = "404",
            description = "Price not found",
            content =
                @Content(
                    mediaType = "application/json",
                    examples =
                        @ExampleObject(
                            name = "priceNotFound",
                            description =
                                "Error response when a final price to apply to the product was not found",
                            value =
                                """
                                 {
                                    "title": "Price not found",
                                    "source": "DATA_REPOSITORY",
                                    "detail": "Price with productId: 35455, applicationDate: 2021-12-31T23:00, brandId: 1 not found"
                                 }
                                """),
                    schema = @Schema(implementation = GlobalExceptionHandler.ErrorResponse.class))),
        @ApiResponse(
            responseCode = "409",
            description = "Multiple prices found",
            content =
                @Content(
                    mediaType = "application/json",
                    examples =
                        @ExampleObject(
                            name = "MultiplePricesFound",
                            description =
                                "Error response when multiple final prices were found to apply to the product",
                            value =
                                """
                                 {
                                    "title": "Multiple prices found",
                                    "source": "BUSINESS_SERVICE",
                                    "detail": "Multiple prices found for the given criteria"
                                 }
                                """),
                    schema = @Schema(implementation = GlobalExceptionHandler.ErrorResponse.class)))
      })
  PriceResponse getPrice(
      @Parameter(description = "Product Identifier.", example = "35455", required = true)
          Integer productId,
      @Parameter(
              description = "Product application date.",
              example = "2020-12-31 23:00:00",
              required = true)
          LocalDateTime applicationDate,
      @Parameter(description = "Brand Identifier.", example = "1", required = true)
          Integer brandId);
}
