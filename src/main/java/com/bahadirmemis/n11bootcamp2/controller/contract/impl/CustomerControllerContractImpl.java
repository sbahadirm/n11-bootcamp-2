package com.bahadirmemis.n11bootcamp2.controller.contract.impl;

import com.bahadirmemis.n11bootcamp2.controller.contract.CustomerControllerContract;
import com.bahadirmemis.n11bootcamp2.dao.CustomerRepository;
import com.bahadirmemis.n11bootcamp2.dto.CustomerDTO;
import com.bahadirmemis.n11bootcamp2.entity.Customer;
import com.bahadirmemis.n11bootcamp2.mapper.CustomerMapper;
import com.bahadirmemis.n11bootcamp2.request.CustomerSaveRequest;
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

    Customer customer = CustomerMapper.INSTANCE.convertToCustomer(request);

    customer = customerRepository.save(customer);

    CustomerDTO customerDTO = CustomerMapper.INSTANCE.convertToCustomerDTO(customer);

    return customerDTO;
  }

  @Override
  public List<CustomerDTO> getAllCustomers() {

    List<Customer> customerList = customerRepository.findAll();

    List<CustomerDTO> customerDTOList = CustomerMapper.INSTANCE.convertToCustomerDTOs(customerList);

    return customerDTOList;
  }
}
