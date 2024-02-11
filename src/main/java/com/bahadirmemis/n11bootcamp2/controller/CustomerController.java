package com.bahadirmemis.n11bootcamp2.controller;

import com.bahadirmemis.n11bootcamp2.entity.Customer;
import com.bahadirmemis.n11bootcamp2.service.CustomerService;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author bahadirmemis
 */
@RestController
@RequestMapping("/api/customers")
public class CustomerController {

  //@Autowired// field injection
  private CustomerService customerService;

  // constructor injection
  public CustomerController(CustomerService customerService) {
    this.customerService = customerService;
  }

  @GetMapping
  public List<Customer> getAllCustomers(){
    List<Customer> allCustomers = customerService.getAllCustomers();
    return allCustomers;
  }

  @GetMapping("/{id}")
  public Customer getCustomerById(@PathVariable Long id){
    Customer customerById = customerService.getCustomerById(id);
    return customerById;
  }

  @PostMapping
  public Customer saveCustomer(@RequestBody Customer customer){
    Customer savedCustomer = customerService.saveCustomer(customer);
    return savedCustomer;
  }

  @DeleteMapping("/{id}")
  public void deleteCustomer(@PathVariable Long id){
    customerService.deleteCustomer(id);
  }

  @PutMapping("/{debugCustomerId}")
  public Customer updateCustomer(Long debugCustomerId, @RequestBody Customer customer){
    return customerService.updateCustomer(customer);
  }

  /**
   * http://localhost:8080/ -> baseURL
   * api/customers -> baseURI
   * /1 -> PathVariable
   * ?name=sadık bahadır -> RequestParam
   */
  @PatchMapping("/{id}")
  public Customer updateCustomerName(@PathVariable Long id, @RequestParam String name){
    return customerService.updateCustomerName(id, name);
  }

  //@RequestMapping(method = RequestMethod.GET)
  //@GetMapping
  //public String test() {
  //  System.out.println("controller test");
  //  String test = customerService.test();
  //
  //  return test;
  //}
  //
  //@GetMapping("/test")
  ////@RequestMapping(path = "/test", method = RequestMethod.GET)
  //public String test2() {
  //  System.out.println("controller test 2");
  //  String test = customerService.test();
  //
  //  return test;
  //}
  //
  //@PostMapping
  ////@RequestMapping(method = RequestMethod.POST)
  //public String testPost() {
  //  System.out.println("controller test post");
  //  String test = customerService.test();
  //
  //  return test;
  //}

  // @Autowired // setter injection
  //public void setCustomerService2(CustomerService customerService2) {
  //  this.customerService2 = customerService2;
  //}
}
