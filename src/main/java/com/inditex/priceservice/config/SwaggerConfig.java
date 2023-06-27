package com.inditex.priceservice.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
  @Bean
  public OpenAPI openApi() {
    return new OpenAPI()
        .info(
            new Info()
                .title("Ecommerce API Specification for price operations")
                .description("A simple ecommerce API that allows operations with product prices.")
                .termsOfService("")
                .version("1.0-SNAPSHOT")
                .license(new License().name("").url("http://unlicense.org"))
                .contact(
                    new io.swagger.v3.oas.models.info.Contact().email("jnrcuadrosr@gmail.com")));
  }
}
