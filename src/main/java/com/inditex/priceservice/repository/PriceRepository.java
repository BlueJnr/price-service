package com.inditex.priceservice.repository;

import com.inditex.priceservice.model.dto.PriceDto;
import com.inditex.priceservice.model.dto.PriceParamDto;
import com.inditex.priceservice.model.entity.PriceEntity;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface PriceRepository extends CrudRepository<PriceEntity, Integer> {
  @Query(
      """
          SELECT new com.inditex.priceservice.model.dto.PriceDto(p.brand.id,
                 p.priceList.id,
                 p.product.id,
                 p.startDate,
                 p.endDate,
                 p.priority,
                 p.price)
          FROM PriceEntity p
          WHERE p.product.id = :#{#priceParamDto.productId}
            AND (:#{#priceParamDto.applicationDate} BETWEEN p.startDate AND p.endDate)
            AND p.brand.id = :#{#priceParamDto.brandId}
  """)
  List<PriceDto> findAllPrices(@Param("priceParamDto") PriceParamDto priceParamDto);
}
