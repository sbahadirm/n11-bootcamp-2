package com.bahadirmemis.n11bootcamp2.general;

import jakarta.persistence.Embedded;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

/**
 * @author bahadirmemis
 */
@MappedSuperclass
@Getter
@Setter
public abstract class BaseEntity implements BaseModel {

  @Embedded
  private BaseAdditionalFields baseAdditionalFields;
}
