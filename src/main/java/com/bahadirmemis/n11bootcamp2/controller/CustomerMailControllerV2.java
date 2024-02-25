package com.bahadirmemis.n11bootcamp2.controller;

import com.bahadirmemis.n11bootcamp2.client.MailClient;
import com.bahadirmemis.n11bootcamp2.dto.CustomerMailInfoDTO;
import com.bahadirmemis.n11bootcamp2.dto.SendMailRequestDTO;
import java.util.HashMap;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * @author bahadirmemis
 */
@RestController
@RequestMapping("api/v2/mails")
@Slf4j
@RequiredArgsConstructor
public class CustomerMailControllerV2 {

  private final MailClient mailClient;

  @GetMapping("/default-mail-address")
  public String getDefaultMailAddress() {

    String defaultMailAddress = mailClient.getDefaultMailAddress();

    log.info("Default Mail Address " + defaultMailAddress);
    return defaultMailAddress;
  }

  @GetMapping
  public CustomerMailInfoDTO test() {

    CustomerMailInfoDTO mailSendInfoDTO = mailClient.getMailSendInfoDTO(1L, "test");
    return mailSendInfoDTO;
  }

  @GetMapping("test-send-mail")
  public CustomerMailInfoDTO testSendMail() {

    SendMailRequestDTO sendMailRequestDTO =
        new SendMailRequestDTO("yusuf@gmail.com", "3.ders", "ders 12 40 gibi bitecek");
    CustomerMailInfoDTO customerMailInfoDTO = mailClient.sendMail(sendMailRequestDTO);
    return customerMailInfoDTO;
  }

  @GetMapping("test-send-mail-put")
  public void testSendMailPut() {

    SendMailRequestDTO sendMailRequestDTO =
        new SendMailRequestDTO("yusuf@gmail.com", "3.ders put", "ders 12 40 gibi bitecek");

    mailClient.sendMailPut(sendMailRequestDTO);
  }

  @GetMapping("/test-delete")
  public void delete(){

    mailClient.delete(1L);
  }

}
