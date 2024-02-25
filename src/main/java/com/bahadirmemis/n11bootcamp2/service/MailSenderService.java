package com.bahadirmemis.n11bootcamp2.service;

import com.bahadirmemis.n11bootcamp2.client.MailClient;
import com.bahadirmemis.n11bootcamp2.dto.SendBatchMailRequestDTO;
import java.util.concurrent.CompletableFuture;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author bahadirmemis
 */
@Service
@RequiredArgsConstructor
public class MailSenderService {

  private final MailClient mailClient;

  @Async
  public CompletableFuture<Integer> sendBatchMailAsync(SendBatchMailRequestDTO request) {
    Integer successCount = mailClient.sendBatchMail(request);
    return CompletableFuture.completedFuture(successCount);
  }
}
