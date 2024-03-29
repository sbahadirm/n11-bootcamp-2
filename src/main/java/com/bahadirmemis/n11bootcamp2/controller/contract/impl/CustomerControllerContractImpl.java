package com.bahadirmemis.n11bootcamp2.controller.contract.impl;

import com.bahadirmemis.n11bootcamp2.controller.contract.CustomerControllerContract;
import com.bahadirmemis.n11bootcamp2.dto.CustomerDTO;
import com.bahadirmemis.n11bootcamp2.entity.Customer;
import com.bahadirmemis.n11bootcamp2.enums.EnumStatus;
import com.bahadirmemis.n11bootcamp2.errormessage.CustomerErrorMessage;
import com.bahadirmemis.n11bootcamp2.general.N11BusinessException;
import com.bahadirmemis.n11bootcamp2.mapper.CustomerMapper;
import com.bahadirmemis.n11bootcamp2.request.CustomerSaveRequest;
import com.bahadirmemis.n11bootcamp2.request.CustomerUpdatePasswordRequest;
import com.bahadirmemis.n11bootcamp2.request.CustomerUpdateRequest;
import com.bahadirmemis.n11bootcamp2.service.entityservice.CustomerEntityService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author bahadirmemis
 */
@RequiredArgsConstructor
@Service
@Slf4j
public class CustomerControllerContractImpl implements CustomerControllerContract {

  private final CustomerEntityService customerEntityService;

  @Override
  public CustomerDTO saveCustomer(CustomerSaveRequest request) {

    Customer customer = CustomerMapper.INSTANCE.convertToCustomer(request);

    customer = customerEntityService.save(customer);

    return CustomerMapper.INSTANCE.convertToCustomerDTO(customer);
  }

  @Override
  public List<CustomerDTO> getAllCustomers() {

    List<Customer> customerList = customerEntityService.findAll();

    return CustomerMapper.INSTANCE.convertToCustomerDTOs(customerList);
  }

  @Override
  public CustomerDTO updateCustomer(CustomerUpdateRequest request) {

    Customer customer = customerEntityService.findByIdWithControl(request.id());
    CustomerMapper.INSTANCE.updateCustomerFields(customer, request);

    customerEntityService.testVoidMethod(request.id(), request.name(), customer);
    customerEntityService.save(customer);

    return CustomerMapper.INSTANCE.convertToCustomerDTO(customer);
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

  @Override
  public CustomerDTO updateCustomerPassword(Long id, CustomerUpdatePasswordRequest request) {

    Customer customer = customerEntityService.findByIdWithControl(id);

    if (!customer.getPassword().equals(request.oldPass())) {
      throw new N11BusinessException(CustomerErrorMessage.INVALID_OLD_PASSWORD);
    }

    if (!request.newPass().equals(request.newPass2())) {
      throw new N11BusinessException(CustomerErrorMessage.NEW_PASSWORDS_DID_NOT_MATCH);
    }

    customer.setPassword(request.newPass());
    customerEntityService.save(customer);

    return CustomerMapper.INSTANCE.convertToCustomerDTO(customer);
  }

  @Override
  public CustomerDTO getCustomerByUsername(String username) {
    Customer customer = customerEntityService.findCustomerByUsername(username);

    List<Customer> customerList =
        customerEntityService.findByNameAndSurnameAndStatus(customer.getName(), customer.getSurname(),
                                                            EnumStatus.ACTIVE);

    for (Customer customer1 : customerList) {
      log.info(customer1.getUsername());
    }

    return CustomerMapper.INSTANCE.convertToCustomerDTO(customer);
  }
}
