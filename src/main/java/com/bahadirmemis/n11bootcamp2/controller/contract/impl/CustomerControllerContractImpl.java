package com.bahadirmemis.n11bootcamp2.controller.contract.impl;

import com.bahadirmemis.n11bootcamp2.controller.contract.CustomerControllerContract;
import com.bahadirmemis.n11bootcamp2.dto.CustomerDTO;
import com.bahadirmemis.n11bootcamp2.entity.Customer;
import com.bahadirmemis.n11bootcamp2.mapper.CustomerMapper;
import com.bahadirmemis.n11bootcamp2.request.CustomerSaveRequest;
import com.bahadirmemis.n11bootcamp2.request.CustomerUpdateRequest;
import com.bahadirmemis.n11bootcamp2.service.entityservice.CustomerEntityService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author bahadirmemis
 */
@RequiredArgsConstructor
@Service
public class CustomerControllerContractImpl implements CustomerControllerContract {

  private final CustomerEntityService customerEntityService;

  @Override
  public CustomerDTO saveCustomer(CustomerSaveRequest request) {

    Customer customer = CustomerMapper.INSTANCE.convertToCustomer(request);

    customer = customerEntityService.save(customer);

    CustomerDTO customerDTO = CustomerMapper.INSTANCE.convertToCustomerDTO(customer);

    return customerDTO;
  }

  @Override
  public List<CustomerDTO> getAllCustomers() {

    List<Customer> customerList = customerEntityService.findAll();

    List<CustomerDTO> customerDTOList = CustomerMapper.INSTANCE.convertToCustomerDTOs(customerList);

    return customerDTOList;
  }

  @Override
  public CustomerDTO updateCustomer(CustomerUpdateRequest request) {

    Customer customer = customerEntityService.findByIdWithControl(request.id());
    CustomerMapper.INSTANCE.updateCustomerFields(customer, request);

    customerEntityService.save(customer);

    CustomerDTO customerDTO = CustomerMapper.INSTANCE.convertToCustomerDTO(customer);

    return customerDTO;
  }

  @Override
  public CustomerDTO getCustomerById(Long id) {
    Customer customer = customerEntityService.findByIdWithControl(id);
    return CustomerMapper.INSTANCE.convertToCustomerDTO(customer);
  }

  @Override
  public void deleteCustomer(Long id) {
    customerEntityService.delete(id);
  }
}
