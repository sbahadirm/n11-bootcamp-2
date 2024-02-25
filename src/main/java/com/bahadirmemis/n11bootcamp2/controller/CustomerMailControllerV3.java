package com.bahadirmemis.n11bootcamp2.controller;

import com.bahadirmemis.n11bootcamp2.client.MailClient;
import com.bahadirmemis.n11bootcamp2.dto.CustomerMailInfoDTO;
import com.bahadirmemis.n11bootcamp2.dto.SendBatchMailRequestDTO;
import com.bahadirmemis.n11bootcamp2.dto.SendMailRequestDTO;
import com.bahadirmemis.n11bootcamp2.mapper.MailMapper;
import com.bahadirmemis.n11bootcamp2.request.SendBatchMailsRequest;
import com.bahadirmemis.n11bootcamp2.service.MailSenderService;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
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
  private final MailSenderService mailSenderService;

  @PostMapping("/batch")
  public Integer sendBatchMails(@RequestBody SendBatchMailsRequest request){
    var sendBatchMailRequestDTO = MailMapper.INSTANCE.convertToSendBatchMailRequestDTO(request);
    Integer successCount = mailClient.sendBatchMail(sendBatchMailRequestDTO);
    return successCount;
  }

  @PostMapping("/batch/fast")
  public void sendBatchMailsAsync(@RequestBody SendBatchMailsRequest request)
      throws ExecutionException, InterruptedException {
    var sendBatchMailRequestDTO = MailMapper.INSTANCE.convertToSendBatchMailRequestDTO(request);
    CompletableFuture<Integer> integerCompletableFuture = mailSenderService.sendBatchMailAsync(sendBatchMailRequestDTO);
    //Integer i = integerCompletableFuture.get();
    //System.out.println(i);
    System.out.println("bitti");
  }
}
