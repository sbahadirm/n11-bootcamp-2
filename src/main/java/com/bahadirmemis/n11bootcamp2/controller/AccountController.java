package com.bahadirmemis.n11bootcamp2.controller;

import com.bahadirmemis.n11bootcamp2.controller.contract.AccountControllerContract;
import com.bahadirmemis.n11bootcamp2.dto.AccountDTO;
import com.bahadirmemis.n11bootcamp2.dto.CustomerDTO;
import com.bahadirmemis.n11bootcamp2.general.RestResponse;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author bahadirmemis
 */
@RestController
@RequestMapping("/api/v1/accounts")
@RequiredArgsConstructor
public class AccountController {

  private final AccountControllerContract contract;

  @GetMapping
  public ResponseEntity<RestResponse<List<AccountDTO>>> getAllAccounts() {
    List<AccountDTO> accounts = contract.getAllAccounts();
    return ResponseEntity.ok(RestResponse.of(accounts));
  }
}
