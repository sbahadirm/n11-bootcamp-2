package com.bahadirmemis.n11bootcamp2.controller;

import com.bahadirmemis.n11bootcamp2.dto.CustomerMailInfoDTO;
import com.bahadirmemis.n11bootcamp2.dto.SendMailRequestDTO;
import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

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

    var url = "http://localhost:8081/api/v1/mails/{id}/infos";
    Map<String, String> params = new HashMap<>();
    params.put("id", "1");

    var restTemplate = new RestTemplate();
    //ResponseEntity<String> stringResponseEntity = restTemplate.getForEntity(url, String.class);
    //String body = stringResponseEntity.getBody();
    var customerMailInfoDTOResponseEntity = restTemplate.getForEntity(url, CustomerMailInfoDTO.class, params);
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

  @GetMapping("/test-with-query-params")
  public CustomerMailInfoDTO test2() {

    Map<String, String> params = new HashMap<>();
    params.put("id", "1");
    params.put("topic-name", "test");

    String url = UriComponentsBuilder.fromHttpUrl("http://localhost:8081/api/v1/mails/{id}/infos")
                                     .queryParam("topic", "{topic-name}")
                                     .buildAndExpand(params)
                                     .toUriString();

    var restTemplate = new RestTemplate();
    var customerMailInfoDTOResponseEntity = restTemplate.getForEntity(url, CustomerMailInfoDTO.class, params);
    var customerMailInfoDTO = customerMailInfoDTOResponseEntity.getBody();

    return customerMailInfoDTO;
  }

  @GetMapping("test-send-mail")
  public CustomerMailInfoDTO testSendMail() {

    String url = "http://localhost:8081/api/v1/mails";

    SendMailRequestDTO sendMailRequestDTO =
        new SendMailRequestDTO("yusuf@gmail.com", "selam evlat!", "naber nasılsın?");

    RestTemplate restTemplate = new RestTemplate();
    var responseEntity = restTemplate.postForEntity(url, sendMailRequestDTO, CustomerMailInfoDTO.class);
    var customerMailInfoDTO = responseEntity.getBody();

    return customerMailInfoDTO;
  }

  @GetMapping("test-send-mail-put")
  public void testSendMailPut() {

    String url = "http://localhost:8081/api/v1/mails";

    SendMailRequestDTO sendMailRequestDTO =
        new SendMailRequestDTO("yusuf@gmail.com", "selam evlat!", "naber nasılsın?");

    RestTemplate restTemplate = new RestTemplate();
    restTemplate.put(url, sendMailRequestDTO);
  }

  @GetMapping("/test-delete")
  public void delete(){

    String url = "http://localhost:8081/api/v1/mails/{id}";

    Map<String, String> params = new HashMap<>();
    params.put("id", "1");

    RestTemplate restTemplate = new RestTemplate();
    restTemplate.delete(url, params);

  }
}
