package com.bahadirmemis.n11bootcamp2.general;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * @author bahadirmemis
 */
@Service
@RequiredArgsConstructor
public class KafkaProducerService {

  private final KafkaTemplate<String, String> kafkaTemplate;

  public void sendMessage(String topic, String message){
    kafkaTemplate.send(topic, message);
  }
}
