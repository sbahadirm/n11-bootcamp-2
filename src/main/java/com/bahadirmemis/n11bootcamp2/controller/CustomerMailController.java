package com.bahadirmemis.n11bootcamp2.controller;

import com.bahadirmemis.n11bootcamp2.dto.CustomerMailInfoDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author bahadirmemis
 */
@RestController
@RequestMapping("api/v1/mails")
@Slf4j
public class CustomerMailController {

  @GetMapping("/default-mail-address")
  public String getDefaultMailAddress() {

    String ulr = "http://localhost:8081/api/v1/mails/default";

    RestTemplate restTemplate = new RestTemplate();
    //ResponseEntity<String> strResponseEntity = restTemplate.getForEntity(ulr, String.class);
    //String defaultMailAddress = strResponseEntity.getBody();
    String defaultMailAddress = restTemplate.getForObject(ulr, String.class);

    log.info("Default Mail Address " + defaultMailAddress);
    return defaultMailAddress;
  }

  @GetMapping
  public CustomerMailInfoDTO test() {

    var url = "http://localhost:8081/api/v1/mails/1/infos";

    var restTemplate = new RestTemplate();
    //ResponseEntity<String> stringResponseEntity = restTemplate.getForEntity(url, String.class);
    //String body = stringResponseEntity.getBody();
    var customerMailInfoDTOResponseEntity = restTemplate.getForEntity(url, CustomerMailInfoDTO.class);
    var customerMailInfoDTO = customerMailInfoDTOResponseEntity.getBody();

    /**
     * {
     *    "receiver":"yusuf@memis.com",
     *    "sender":"sbahadirm@gmail.com",
     *    "mailDate":"2024-02-25T10:42:02.012106",
     *    "topic":"Naber oğlum!"
     * }
     */
    return customerMailInfoDTO;
  }
}
