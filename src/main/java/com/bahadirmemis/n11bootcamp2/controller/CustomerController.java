package com.bahadirmemis.n11bootcamp2.controller;

import com.bahadirmemis.n11bootcamp2.controller.contract.CustomerControllerContract;
import com.bahadirmemis.n11bootcamp2.dto.CustomerDTO;
import com.bahadirmemis.n11bootcamp2.request.CustomerSaveRequest;
import com.bahadirmemis.n11bootcamp2.request.CustomerUpdateRequest;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author bahadirmemis
 */
@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

  private CustomerControllerContract customerControllerContract;

  public CustomerController(CustomerControllerContract customerControllerContract) {
    this.customerControllerContract = customerControllerContract;
  }

  @GetMapping
  public List<CustomerDTO> getAllCustomers() {
    List<CustomerDTO> allCustomers = customerControllerContract.getAllCustomers();
    return allCustomers;
  }
  //
  //@GetMapping("/{id}")
  //public Customer getCustomerById(@PathVariable Long id) {
  //  Customer customerById = customerControllerContract.getCustomerById(id);
  //  return customerById;
  //}

  @PostMapping
  public CustomerDTO saveCustomer(@RequestBody CustomerSaveRequest request) {
    CustomerDTO savedCustomer = customerControllerContract.saveCustomer(request);
    return savedCustomer;
  }

  ///**
  // * DELETE -> api/customers/66
  // * @param id
  // */
  //@DeleteMapping("/{id}")
  //public void deleteCustomer(@PathVariable Long id) {
  //  customerControllerContract.deleteCustomer(id);
  //}
  //
  ///**
  // * DELETE -> api/customers/with-username/sbahadirm
  // * @param username
  // */
  //@DeleteMapping("/{username}")
  //public void deleteCustomer(@PathVariable String username) {
  //  customerControllerContract.deleteCustomer(username);
  //}
  //
  ///**
  // * PUT -> api/customers/6478545
  // * @param debugCustomerId
  // * @param customer
  // * @return
  // */
  @PutMapping("/{debugCustomerId}")
  public CustomerDTO updateCustomer(@PathVariable Long debugCustomerId, @RequestBody CustomerUpdateRequest request) {
    return customerControllerContract.updateCustomer(request);
  }
  //
  /////**
  //// * http://localhost:8080/ -> baseURL
  //// * api/customers -> baseURI
  //// * /1 -> PathVariable
  //// * ?name=sadık bahadır -> RequestParam
  //// */
  ////@PatchMapping("/{id}")
  ////public Customer updateCustomerPassword(@PathVariable Long id, @RequestParam String name) {
  ////  return customerControllerContract.updateCustomerPassword(id, name);
  ////}
}
