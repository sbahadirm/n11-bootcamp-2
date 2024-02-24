package com.bahadirmemis.n11bootcamp2.converter;

import com.bahadirmemis.n11bootcamp2.dto.CustomerDTO;
import com.bahadirmemis.n11bootcamp2.entity.Customer;
import com.bahadirmemis.n11bootcamp2.enums.EnumStatus;
import com.bahadirmemis.n11bootcamp2.request.CustomerSaveRequest;

/**
 * @author bahadirmemis
 */
public class CustomerConverter {

  private CustomerConverter() {
  }

  public static CustomerDTO convertToCustomerDTO(Customer customer) {
    return new CustomerDTO(customer.getId(), customer.getName(), customer.getSurname(), customer.getBirthDate(),
                        customer.getUsername(), customer.getIdentityNo(), customer.getPhoneNumber(),
                        customer.getEmail(), customer.getStatus());
  }

  public static Customer convertToCustomer(CustomerSaveRequest request) {
    Customer customer = new Customer();
    customer.setName(request.nameXXX());
    customer.setSurname(request.surname());
    if (request.birthDate() != null){
      customer.setBirthDate(request.birthDate());
    }
    customer.setUsername(request.username());
    customer.setIdentityNo(request.identityNo());
    customer.setPassword(request.password());
    customer.setPhoneNumber(request.phoneNumber());
    customer.setEmail(request.email());
    customer.setStatus(EnumStatus.ACTIVE);
    return customer;
  }

}
