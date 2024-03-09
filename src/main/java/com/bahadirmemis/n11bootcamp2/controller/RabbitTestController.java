package com.bahadirmemis.n11bootcamp2.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author bahadirmemis
 */
@RestController
@RequiredArgsConstructor
public class RabbitTestController {

  private final RabbitTemplate rabbitTemplate;

  @PostMapping("/rabbit/test")
  public String testRabbit(@RequestBody String message){

    rabbitTemplate.convertAndSend("exchangeName", "routingKey", message);

    return message;
  }
}
