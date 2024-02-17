package com.bahadirmemis.n11bootcamp2.dao;

import com.bahadirmemis.n11bootcamp2.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author bahadirmemis
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
