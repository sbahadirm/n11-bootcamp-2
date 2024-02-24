package com.bahadirmemis.n11bootcamp2.service.entityservice;

import com.bahadirmemis.n11bootcamp2.dao.CustomerRepository;
import com.bahadirmemis.n11bootcamp2.entity.Customer;
import com.bahadirmemis.n11bootcamp2.enums.EnumStatus;
import com.bahadirmemis.n11bootcamp2.general.BaseEntityService;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * @author bahadirmemis
 */
@Service
public class CustomerEntityService extends BaseEntityService<Customer, CustomerRepository> {

  protected CustomerEntityService(CustomerRepository repository) {
    super(repository);
  }

  public Customer findCustomerByUsername(String username){
    return getRepository().findCustomerByUsername(username);
  }

  public List<Customer> findByNameAndSurnameAndStatus(String name, String surname, EnumStatus status){
    return getRepository().findAllByNameAndSurnameAndStatus(name, surname, status);
  }

  public void testVoidMethod(Long id, String name, Customer customer){

  }
}
