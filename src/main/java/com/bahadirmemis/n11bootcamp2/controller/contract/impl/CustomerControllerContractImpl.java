package com.bahadirmemis.n11bootcamp2.controller.contract.impl;

import com.bahadirmemis.n11bootcamp2.controller.contract.CustomerControllerContract;
import com.bahadirmemis.n11bootcamp2.converter.CustomerConverter;
import com.bahadirmemis.n11bootcamp2.dao.CustomerRepository;
import com.bahadirmemis.n11bootcamp2.dto.CustomerDTO;
import com.bahadirmemis.n11bootcamp2.entity.Customer;
import com.bahadirmemis.n11bootcamp2.enums.EnumState;
import com.bahadirmemis.n11bootcamp2.request.CustomerSaveRequest;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author bahadirmemis
 */
@RequiredArgsConstructor
@Service
public class CustomerControllerContractImpl implements CustomerControllerContract {

  private final CustomerRepository customerRepository;

  @Override
  public CustomerDTO saveCustomer(CustomerSaveRequest request) {

    Customer customer = CustomerConverter.convertToCustomer(request);

    customer = customerRepository.save(customer);

    CustomerDTO customerDTO = CustomerConverter.convertToCustomerDTO(customer);

    return customerDTO;
  }

  @Override
  public List<CustomerDTO> getAllCustomers() {

    List<Customer> customerList = customerRepository.findAll();

    List<CustomerDTO> customerDTOList = new ArrayList<>();
    for (Customer customer : customerList) {
      CustomerDTO customerDTO = CustomerConverter.convertToCustomerDTO(customer);
      customerDTOList.add(customerDTO);
    }

    return customerDTOList;
  }
}
