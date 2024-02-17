package com.bahadirmemis.n11bootcamp2.general;

import jakarta.persistence.Embeddable;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

/**
 * createdAt, createdBy, updatedAt, updatedBy
 * @author bahadirmemis
 */
@Embeddable
@Getter
@Setter
public class BaseAdditionalFields {

  private LocalDateTime createDate;
  private LocalDateTime updateDate;
  private Long creatorId;
  private Long updaterId;
}
