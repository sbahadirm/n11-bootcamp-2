package com.bahadirmemis.n11bootcamp2.client;

import com.bahadirmemis.n11bootcamp2.dto.CustomerMailInfoDTO;
import com.bahadirmemis.n11bootcamp2.dto.SendMailRequestDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author bahadirmemis
 */
@FeignClient(value = "mail", url = "http://localhost:8081/api/v1/mails")
public interface MailClient {

  @GetMapping("/default")
  String getDefaultMailAddress();

  @GetMapping("{id}/infos")
  CustomerMailInfoDTO getMailSendInfoDTO(@PathVariable Long id, @RequestParam String topic);

  @PostMapping
  CustomerMailInfoDTO sendMail(@RequestBody SendMailRequestDTO request);

  @PutMapping
  void sendMailPut(@RequestBody SendMailRequestDTO request);

  @DeleteMapping("/{id}")
  void delete(@PathVariable Long id);
}
