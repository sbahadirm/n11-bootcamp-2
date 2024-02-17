package com.bahadirmemis.n11bootcamp2.controller.contract;

import com.bahadirmemis.n11bootcamp2.dto.CustomerDTO;
import com.bahadirmemis.n11bootcamp2.request.CustomerSaveRequest;
import java.util.List;

/**
 * @author bahadirmemis
 */
public interface CustomerControllerContract {

  CustomerDTO saveCustomer(CustomerSaveRequest request);

  List<CustomerDTO> getAllCustomers();
}