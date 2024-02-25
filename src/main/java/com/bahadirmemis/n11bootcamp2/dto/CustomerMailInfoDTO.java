package com.bahadirmemis.n11bootcamp2.dto;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
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
public class CustomerMailInfoDTO {

  private String receiver;
  private String sender;
  private LocalDateTime mailDate;
  private String topic;

}
