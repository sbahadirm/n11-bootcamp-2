package com.bahadirmemis.n11bootcamp2.controller;

import com.bahadirmemis.n11bootcamp2.client.MailClient;
import com.bahadirmemis.n11bootcamp2.dto.CustomerMailInfoDTO;
import com.bahadirmemis.n11bootcamp2.dto.SendBatchMailRequestDTO;
import com.bahadirmemis.n11bootcamp2.dto.SendMailRequestDTO;
import com.bahadirmemis.n11bootcamp2.mapper.MailMapper;
import com.bahadirmemis.n11bootcamp2.request.SendBatchMailsRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author bahadirmemis
 */
@RestController
@RequestMapping("api/v2/mails")
@Slf4j
@RequiredArgsConstructor
public class CustomerMailControllerV3 {

  private final MailClient mailClient;

  @PostMapping("/batch")
  public Integer sendBatchMails(@RequestBody SendBatchMailsRequest request){
    var sendBatchMailRequestDTO = MailMapper.INSTANCE.convertToSendBatchMailRequestDTO(request);
    Integer successCount = mailClient.sendBatchMail(sendBatchMailRequestDTO);
    return successCount;
  }
}
