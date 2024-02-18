package com.bahadirmemis.n11bootcamp2.transactional.util;

import com.bahadirmemis.n11bootcamp2.entity.Customer;
import com.bahadirmemis.n11bootcamp2.enums.EnumStatus;
import java.time.LocalDate;
import org.springframework.util.StringUtils;

/**
 * @author Bahadır Memiş
 * @since 1.0.0
 */
public class TransactionalUtil {

  public static Customer getDummyCustomer(String suffix) {

    String testName = "test";
    if (StringUtils.hasText(suffix)) {
      testName = testName + "-" + suffix;
    }

    Customer customer = new Customer();
    customer.setName(testName);
    customer.setSurname(testName);
    customer.setIdentityNo("12312312312");
    customer.setPassword("123");
    customer.setBirthDate(LocalDate.now());
    customer.setUsername("sbahadirm");
    customer.setPhoneNumber("3367434");
    customer.setEmail("sbahasdgsjkhd@gfmail.com");
    customer.setStatus(EnumStatus.ACTIVE);

    return customer;
  }
}
