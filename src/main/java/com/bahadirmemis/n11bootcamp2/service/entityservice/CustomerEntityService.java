package com.bahadirmemis.n11bootcamp2.service.entityservice;

import com.bahadirmemis.n11bootcamp2.dao.CustomerRepository;
import com.bahadirmemis.n11bootcamp2.entity.Customer;
import com.bahadirmemis.n11bootcamp2.general.BaseEntityService;
import org.springframework.stereotype.Service;

/**
 * @author bahadirmemis
 */
@Service
public class CustomerEntityService extends BaseEntityService<Customer, CustomerRepository> {

  protected CustomerEntityService(CustomerRepository repository) {
    super(repository);
  }
}
