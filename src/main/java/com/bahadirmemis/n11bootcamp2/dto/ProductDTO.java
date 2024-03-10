package com.bahadirmemis.n11bootcamp2.dto;

import com.bahadirmemis.n11bootcamp2.enums.EnumStatus;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author bahadirmemis
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDTO {

  private Long id;
  private String name;
  private BigDecimal price;
  private EnumStatus status;


}
