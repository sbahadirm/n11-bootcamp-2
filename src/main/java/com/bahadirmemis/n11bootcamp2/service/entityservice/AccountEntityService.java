package com.bahadirmemis.n11bootcamp2.service.entityservice;

import com.bahadirmemis.n11bootcamp2.dao.AccountRepository;
import com.bahadirmemis.n11bootcamp2.entity.Account;
import com.bahadirmemis.n11bootcamp2.general.BaseEntityService;
import org.springframework.stereotype.Service;

/**
 * @author bahadirmemis
 */
@Service
public class AccountEntityService extends BaseEntityService<Account, AccountRepository> {

  protected AccountEntityService(AccountRepository repository) {
    super(repository);
  }
}
