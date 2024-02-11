package com.bahadirmemis.n11bootcamp2.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * @author bahadirmemis
 */
@Component
//@Qualifier("xml")
@Primary
public class ResponseConverterXml implements ResponseConverter {

  @Override
  public String convert() {
    return "XML";
  }
}
