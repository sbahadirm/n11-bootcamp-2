package com.bahadirmemis.n11bootcamp2.controller.contract;

import com.bahadirmemis.n11bootcamp2.dto.AccountDTO;
import java.util.List;

/**
 * @author bahadirmemis
 */
public interface AccountControllerContract {

  List<AccountDTO> getAllAccounts();
}
