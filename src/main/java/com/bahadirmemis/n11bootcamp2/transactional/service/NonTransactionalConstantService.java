package com.bahadirmemis.n11bootcamp2.transactional.service;

import com.bahadirmemis.n11bootcamp2.dao.CustomerRepository;
import com.bahadirmemis.n11bootcamp2.entity.Customer;
import com.bahadirmemis.n11bootcamp2.transactional.util.TransactionalUtil;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Bahadır Memiş
 * @since 1.0.0
 */
@Service
@RequiredArgsConstructor
public class NonTransactionalConstantService {

  private final CustomerRepository customerDao;

  private Map<Long, Customer> map = new LinkedHashMap<>();

  public Customer findById(Long id) {

    Customer customer = map.get(id);
    if (customer != null) {
      return customer;
    }

    Optional<Customer> customerOptional = customerDao.findById(id);

    if (customerOptional.isPresent()) {
      customer = customerOptional.get();
    } else {
      throw new RuntimeException("Error");
    }

    map.put(customer.getId(), customer);

    return customer;
  }

  @Transactional(propagation = Propagation.NEVER)
  public void saveNever() {

    Customer customer = TransactionalUtil.getDummyCustomer("ts20-N");

    customerDao.save(customer);

    System.out.println("end");
  }
}
