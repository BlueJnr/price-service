package com.inditex.priceservice.config;

import com.inditex.priceservice.config.exception.MultiplePricesFoundException;
import com.inditex.priceservice.config.exception.PriceNotFoundException;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(PriceNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  ErrorResponse handlePriceNotFoundException(PriceNotFoundException e) {
    return new ErrorResponse("Price not found", "DATA_REPOSITORY", e.getMessage());
  }

  @ExceptionHandler(MultiplePricesFoundException.class)
  @ResponseStatus(HttpStatus.CONFLICT)
  ErrorResponse handleMultiplePricesFoundException(MultiplePricesFoundException e) {
    return new ErrorResponse("Multiple prices found", "BUSINESS_SERVICE", e.getMessage());
  }

  @Schema(name = "ErrorResponse", description = "Error Response")
  public record ErrorResponse(
      @NotNull @Schema(description = "Error response title", example = "Multiple prices found")
          String title,
      @NotNull @Schema(description = "Error response source", example = "BUSINESS_SERVICE")
          String source,
      @NotNull
          @Schema(
              description = "Error response detail",
              example = "Multiple prices found for the given criteria")
          String detail) {}
}
