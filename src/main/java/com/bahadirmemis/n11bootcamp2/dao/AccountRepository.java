package com.bahadirmemis.n11bootcamp2.dao;

import com.bahadirmemis.n11bootcamp2.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author bahadirmemis
 */
public interface AccountRepository extends JpaRepository<Account, Long> {

}
