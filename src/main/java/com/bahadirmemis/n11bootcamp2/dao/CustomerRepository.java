package com.bahadirmemis.n11bootcamp2.dao;

import com.bahadirmemis.n11bootcamp2.entity.Customer;
import com.bahadirmemis.n11bootcamp2.enums.EnumStatus;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @author bahadirmemis
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {

  /**
   * select * FROM public.customer
   * where username = 'sbahadirm'
   */

  //@Query(" SELECT c FROM Customer c where c.username = :username ")
  Customer findCustomerByUsername(String username);

  List<Customer> findAllByNameAndSurnameAndStatus(String name, String surname, EnumStatus status);

  Customer findByNameAndSurnameAndStatus(String name, String surname, EnumStatus status);

  @Query("select c from Customer c left join Account a on c.id = a.id ")
  Customer findByUsernameWithAccount();

}
