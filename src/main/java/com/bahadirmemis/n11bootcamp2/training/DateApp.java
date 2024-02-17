package com.bahadirmemis.n11bootcamp2.training;

import com.bahadirmemis.n11bootcamp2.entity.Customer;
import com.bahadirmemis.n11bootcamp2.enums.EnumState;
import java.util.Date;

/**
 * @author bahadirmemis
 */
public class DateApp {

  public static void main(String[] args) {

    Date date = new Date(1991, 10, 5); // Thu Nov 05 00:00:00 TRT 3891

    Customer customer = new Customer();
    //customer.setBirthDate(date);

    System.out.println(date);

    EnumState active = EnumState.ACTIVE;
    int ordinal = active.ordinal();
  }
}
