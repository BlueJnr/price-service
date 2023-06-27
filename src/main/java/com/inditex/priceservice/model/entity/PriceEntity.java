package com.inditex.priceservice.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "PRICE")
public class PriceEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID")
  private Integer id;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "BRAND_ID", referencedColumnName = "ID")
  private BrandEntity brand;

  @OneToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "PRICE_LIST_ID", referencedColumnName = "ID")
  private PriceListEntity priceList;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "PRODUCT_ID", referencedColumnName = "ID")
  private ProductEntity product;

  @Column(name = "START_DATE", nullable = false, columnDefinition = "DATETIME")
  private LocalDateTime startDate;

  @Column(name = "END_DATE", nullable = false, columnDefinition = "DATETIME")
  private LocalDateTime endDate;

  @Column(name = "PRIORITY", nullable = false, columnDefinition = "TINYINT")
  private Short priority;

  @Column(name = "PRICE", nullable = false, precision = 10, scale = 2)
  private BigDecimal price;

  @Column(name = "CURR", nullable = false, columnDefinition = "CHAR(3)")
  private String currency;
}
