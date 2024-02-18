package com.bahadirmemis.n11bootcamp2.controller.contract.impl;

import com.bahadirmemis.n11bootcamp2.controller.contract.AccountControllerContract;
import com.bahadirmemis.n11bootcamp2.dto.AccountDTO;
import com.bahadirmemis.n11bootcamp2.entity.Account;
import com.bahadirmemis.n11bootcamp2.mapper.AccountMapper;
import com.bahadirmemis.n11bootcamp2.service.entityservice.AccountEntityService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author bahadirmemis
 */
@Service
@RequiredArgsConstructor
public class AccountControllerContractImpl implements AccountControllerContract {

  private final AccountEntityService accountEntityService;

  @Override
  public List<AccountDTO> getAllAccounts() {
    List<Account> accountList = accountEntityService.findAll();
    return AccountMapper.INSTANCE.convertToAccountDTOs(accountList);
  }
}
