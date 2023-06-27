package com.inditex.priceservice.config.exception;

public class MultiplePricesFoundException extends RuntimeException {

  public MultiplePricesFoundException() {
    super("Multiple prices found for the given criteria");
  }
}
