package com.bahadirmemis.n11bootcamp2.service;

import java.math.BigDecimal;
import org.springframework.stereotype.Service;

/**
 * @author bahadirmemis
 */
@Service
public class CalculatorService {

  /**
   * value1= 24
   * value1= 46
   *
   * result= 70;
   */
  public static BigDecimal sum(BigDecimal value1, BigDecimal value2){
    return value1.add(value2);
  }
}
