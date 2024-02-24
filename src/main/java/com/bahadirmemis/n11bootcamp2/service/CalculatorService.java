package com.bahadirmemis.n11bootcamp2.service;

import java.math.BigDecimal;
import org.springframework.stereotype.Service;

/**
 * @author bahadirmemis
 */
@Service
public class CalculatorService {

  private CalculatorService(){

  }

    /**
     * value1= 24
     * value1= 46
     *
     * result= 70;
     */
  public static BigDecimal sum(BigDecimal value1, BigDecimal value2){
    if (value1 == null){
      value1 = BigDecimal.ZERO;
    }
    if (value2 == null){
      value2 = BigDecimal.ZERO;
    }
    return value1.add(value2);
  }
}
