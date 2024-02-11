package com.bahadirmemis.n11bootcamp2.service;

import com.bahadirmemis.n11bootcamp2.entity.Customer;
import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * Qualifier
 * Primary
 * Autowired by name
 *
 * @author bahadirmemis
 */
@Service
public class CustomerService {

  private ResponseConverter responseConverterJson;

  public CustomerService(ResponseConverter responseConverterJson) {
    this.responseConverterJson = responseConverterJson;
  }

  public List<Customer> getAllCustomers() {
    Customer bahadir = new Customer(1L, "bahadir", "memiş");
    Customer yusuf = new Customer(2L, "yusuf", "memiş");

    return Arrays.asList(bahadir, yusuf);
  }

  public Customer getCustomerById(Long id) {

    List<Customer> allCustomers = getAllCustomers();

    Customer customer = allCustomers.stream().filter(c -> c.getId().equals(id)).findFirst().get();

    return customer;
  }

  public Customer saveCustomer(Customer customer){
    customer.setId(3L);
    return customer;
  }

  public void deleteCustomer(Long id){
    // do nothing
  }

  public Customer updateCustomer(Customer customer){
    Customer customerById = getCustomerById(customer.getId());
    customerById.setName(customer.getName());
    customerById.setSurname(customer.getSurname());
    return customerById;
  }

  public Customer updateCustomerName(Long id, String name){
    Customer customerById = getCustomerById(id);
    customerById.setName(name);
    return customerById;
  }

  //public String test() {
  //  String convert = responseConverterJson.convert();
  //  System.out.println("test service ->" + convert);
  //  return convert;
  //}
}
