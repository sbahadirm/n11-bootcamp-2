package com.bahadirmemis.n11bootcamp2.service;

import java.math.BigDecimal;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author bahadirmemis
 */
class CalculatorServiceTest {

  @Test
  void shouldSum() {

    BigDecimal value1 = BigDecimal.valueOf(24);
    BigDecimal value2 = BigDecimal.valueOf(46);

    BigDecimal result = CalculatorService.sum(value1, value2);

    assertEquals(BigDecimal.valueOf(70), result);

    //if (result.equals(BigDecimal.valueOf(70))){
    //  System.out.println("evet bu");
    //} else {
    //  System.err.println("hata");
    //}
  }

  @Test
  void shouldSumWhenValue1IsNull() {

    BigDecimal value1 = null;
    BigDecimal value2 = BigDecimal.valueOf(46);

    BigDecimal result = CalculatorService.sum(value1, value2);

    assertEquals(BigDecimal.valueOf(46), result);
  }

  @Test
  void shouldSumWhenValue2IsNull() {

    BigDecimal value1 = BigDecimal.valueOf(46);
    BigDecimal value2 = null;

    BigDecimal result = CalculatorService.sum(value1, value2);

    assertEquals(BigDecimal.valueOf(46), result);
  }

}