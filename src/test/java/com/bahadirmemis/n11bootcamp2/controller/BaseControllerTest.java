package com.bahadirmemis.n11bootcamp2.controller;

import com.bahadirmemis.n11bootcamp2.general.RestResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.UnsupportedEncodingException;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MvcResult;

/**
 * @author bahadirmemis
 */
public class BaseControllerTest {

  protected ObjectMapper objectMapper;

  protected boolean isSuccess(MvcResult mvcResult) throws UnsupportedEncodingException, JsonProcessingException {
    MockHttpServletResponse response = mvcResult.getResponse();
    String content = response.getContentAsString();

    RestResponse restResponse = objectMapper.readValue(content, RestResponse.class);

    boolean success = restResponse.isSuccess();
    return success;
  }
}
