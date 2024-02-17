package com.bahadirmemis.n11bootcamp2.training;

import com.bahadirmemis.n11bootcamp2.dao.CustomerRepository;
import com.bahadirmemis.n11bootcamp2.entity.Book;
import com.bahadirmemis.n11bootcamp2.entity.Customer;
import com.bahadirmemis.n11bootcamp2.enums.EnumState;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author bahadirmemis
 */
public class DateApp {

  private static CustomerRepository customerRepository;

  public static void main(String[] args) {

    Date date = new Date(1991, 10, 5); // Thu Nov 05 00:00:00 TRT 3891

    Customer customer = new Customer();
    String name = customer.getBook().getName();

    List<Customer> customerList = customerRepository.findAll();










    List<Customer> customerList = customerRepository.findAll();


    for (Customer customer1 : customerList) {
      String name1 = customer1.getBook().getName();
    }


    for (Customer customer1 : customerList) {
      Long bookId = customer1.getBook().getId();
      Book book = bookRepository.findById(bookId);
      String name1 = book.getName();
    }



    //customer.setBirthDate(date);

    System.out.println(date);

    EnumState active = EnumState.ACTIVE;
    int ordinal = active.ordinal();
  }
}
