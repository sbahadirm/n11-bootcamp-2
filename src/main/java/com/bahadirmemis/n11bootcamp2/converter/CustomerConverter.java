package com.bahadirmemis.n11bootcamp2.converter;

import com.bahadirmemis.n11bootcamp2.dto.CustomerDTO;
import com.bahadirmemis.n11bootcamp2.entity.Customer;
import com.bahadirmemis.n11bootcamp2.enums.EnumState;
import com.bahadirmemis.n11bootcamp2.request.CustomerSaveRequest;
import java.time.LocalDate;

/**
 * @author bahadirmemis
 */
public class CustomerConverter {

  public static CustomerDTO convertToCustomerDTO(Customer customer) {
    CustomerDTO customerDTO =
        new CustomerDTO(customer.getId(), customer.getName(), customer.getSurname(), customer.getBirthDate(),
                        customer.getUsername(), customer.getIdentityNo(), customer.getPhoneNumber(),
                        customer.getEmail(), customer.getState());
    return customerDTO;
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
    customer.setState(EnumState.ACTIVE);
    return customer;
  }

}
