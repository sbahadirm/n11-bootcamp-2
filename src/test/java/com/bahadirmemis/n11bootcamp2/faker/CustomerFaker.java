package com.bahadirmemis.n11bootcamp2.faker;

import com.bahadirmemis.n11bootcamp2.dto.CustomerDTO;
import com.bahadirmemis.n11bootcamp2.entity.Customer;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * @author bahadirmemis
 */
public class CustomerFaker {

  public Customer customer(){
    Customer customer = new Customer();
    customer.setId(1L);
    customer.setName("name1");
    customer.setSurname("surname1");
    customer.setEmail("nam1@surname1.com");
    return customer;
  }

  public List<Customer> customers(){
    Customer customer1 = new Customer();
    customer1.setName("name1");
    customer1.setSurname("surname1");
    Customer customer2 = new Customer();
    customer2.setName("name2");
    customer2.setSurname("surname2");
    Customer customer3 = new Customer();
    customer3.setName("name3");
    customer3.setSurname("surname3");
    Customer customer4 = new Customer();
    customer4.setName("name4");
    customer4.setSurname("surname4");
    List<Customer> customers = new ArrayList<>();
    customers.add(customer1);
    customers.add(customer2);
    customers.add(customer3);
    customers.add(customer4);
    return customers;
  }


  //public Customer storeMenuDTO() {
  //  return null;
  //  //return new CustomerDTO(id(),name(), surname(), .....);
  //}
  //
  //public List<Customer> storeMenuDTOS() {
  //  return objectStream(this::storeMenuDTO).toList();
  //}
  //
  //public <T> Stream<T> objectStream(Supplier<T> supplier) {
  //  return objectStream(collectionSize(), supplier);
  //}
  //
  //public int collectionSize() {
  //  return 4;
  //  //return faker.number().numberBetween(2, 5);
  //}

}
