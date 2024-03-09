package com.bahadirmemis.n11bootcamp2.controller;

import com.bahadirmemis.n11bootcamp2.dto.CustomerMailInfoDTO;
import com.bahadirmemis.n11bootcamp2.dto.SendMailRequestDTO;
import com.bahadirmemis.n11bootcamp2.general.KafkaProducerService;
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
@RequestMapping("api/v1/mails")
@Slf4j
@RequiredArgsConstructor
public class CustomerMailController {

  @Value("${mail-app-base-url}")
  private String BASE_URL;

  private final KafkaProducerService kafkaProducerService;

  @GetMapping("/default-mail-address")
  public String getDefaultMailAddress() {

    String ulr = BASE_URL + "/default";

    RestTemplate restTemplate = new RestTemplate();
    //ResponseEntity<String> strResponseEntity = restTemplate.getForEntity(ulr, String.class);
    //String defaultMailAddress = strResponseEntity.getBody();
    String defaultMailAddress = restTemplate.getForObject(ulr, String.class);

    log.info("Default Mail Address " + defaultMailAddress);

    kafkaProducerService.sendMessage("infoLog", defaultMailAddress);

    return defaultMailAddress;
  }

  @GetMapping
  public CustomerMailInfoDTO test() {

    var url = BASE_URL + "/{id}/infos";
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

    String url = BASE_URL;

    SendMailRequestDTO sendMailRequestDTO =
        new SendMailRequestDTO("yusuf@gmail.com", "selam evlat!", "naber nasılsın?");

    RestTemplate restTemplate = new RestTemplate();
    var responseEntity = restTemplate.postForEntity(url, sendMailRequestDTO, CustomerMailInfoDTO.class);
    var customerMailInfoDTO = responseEntity.getBody();

    return customerMailInfoDTO;
  }

  @GetMapping("test-send-mail-put")
  public void testSendMailPut() {

    String url = BASE_URL;

    SendMailRequestDTO sendMailRequestDTO =
        new SendMailRequestDTO("yusuf@gmail.com", "selam evlat!", "naber nasılsın?");

    RestTemplate restTemplate = new RestTemplate();
    restTemplate.put(url, sendMailRequestDTO);
  }

  @GetMapping("/test-delete")
  public void delete(){

    String url = BASE_URL + "/{id}";

    Map<String, String> params = new HashMap<>();
    params.put("id", "1");

    RestTemplate restTemplate = new RestTemplate();
    restTemplate.delete(url, params);

  }

  @GetMapping("/test-delete-ex")
  public void deleteEx(){

    String url = BASE_URL + "/{id}";

    Map<String, String> params = new HashMap<>();
    params.put("id", "1");

    HttpHeaders headers = new HttpHeaders();

    RestTemplate restTemplate = new RestTemplate();
    restTemplate.exchange(url, HttpMethod.DELETE, new HttpEntity<>(headers), String.class, params);
  }

  @GetMapping("test-send-mail-ex")
  public CustomerMailInfoDTO testSendMailEx() {

    String url = BASE_URL;

    SendMailRequestDTO sendMailRequestDTO =
        new SendMailRequestDTO("yusuf@gmail.com", "selam evlat!", "naber nasılsın?");

    HttpHeaders headers = new HttpHeaders();
    HttpEntity<SendMailRequestDTO> httpEntity = new HttpEntity<>(sendMailRequestDTO, headers);

    RestTemplate restTemplate = new RestTemplate();
    ResponseEntity<CustomerMailInfoDTO> responseEntity =
        restTemplate.exchange(url, HttpMethod.POST, httpEntity, CustomerMailInfoDTO.class);

    CustomerMailInfoDTO customerMailInfoDTO = responseEntity.getBody();

    return customerMailInfoDTO;
  }
}
