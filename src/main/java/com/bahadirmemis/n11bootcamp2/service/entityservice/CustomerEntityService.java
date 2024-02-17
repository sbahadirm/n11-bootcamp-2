package com.bahadirmemis.n11bootcamp2.service.entityservice;

import com.bahadirmemis.n11bootcamp2.dao.CustomerRepository;
import com.bahadirmemis.n11bootcamp2.entity.Customer;
import com.bahadirmemis.n11bootcamp2.general.BaseAdditionalFields;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author bahadirmemis
 */
@Service
@RequiredArgsConstructor
public class CustomerEntityService {

  private final CustomerRepository customerRepository;

  public Customer save(Customer customer) {

    BaseAdditionalFields baseAdditionalFields = customer.getBaseAdditionalFields();
    if (baseAdditionalFields == null) {
      baseAdditionalFields = new BaseAdditionalFields();
    }

    LocalDateTime now = LocalDateTime.now();
    if (customer.getId() == null) {
      // yeni kayıt
      baseAdditionalFields.setCreateDate(now);
      //customer.getBaseAdditionalFields().setCreatorId();
    }

    baseAdditionalFields.setUpdateDate(now);
    //customer.getBaseAdditionalFields().setUpdaterId();
    customer.setBaseAdditionalFields(baseAdditionalFields);

    customer = customerRepository.save(customer);
    return customer;
  }

  public List<Customer> findAll() {
    return customerRepository.findAll();
  }

  public Customer findById(Long id){
    Optional<Customer> optionalCustomer = customerRepository.findById(id);
    return optionalCustomer.get();
  }
}
