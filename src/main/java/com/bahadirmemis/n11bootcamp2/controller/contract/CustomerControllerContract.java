package com.bahadirmemis.n11bootcamp2.controller.contract;

import com.bahadirmemis.n11bootcamp2.dto.CustomerDTO;
import com.bahadirmemis.n11bootcamp2.request.CustomerSaveRequest;
import com.bahadirmemis.n11bootcamp2.request.CustomerUpdatePasswordRequest;
import com.bahadirmemis.n11bootcamp2.request.CustomerUpdateRequest;
import java.util.List;

/**
 * @author bahadirmemis
 */
public interface CustomerControllerContract {

  CustomerDTO saveCustomer(CustomerSaveRequest request);

  List<CustomerDTO> getAllCustomers();

  CustomerDTO updateCustomer(CustomerUpdateRequest request);

  CustomerDTO getCustomerById(Long id);

  void deleteCustomer(Long id);

  CustomerDTO updateCustomerPassword(Long id, CustomerUpdatePasswordRequest request);

  CustomerDTO getCustomerByUsername(String username);
}
