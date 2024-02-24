package com.bahadirmemis.n11bootcamp2.controller;

import com.bahadirmemis.n11bootcamp2.N11Bootcamp2Application;
import com.bahadirmemis.n11bootcamp2.general.RestResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author bahadirmemis
 */
@ExtendWith(MockitoExtension.class)
@SpringBootTest(classes = {N11Bootcamp2Application.class})
class CustomerControllerTest {

  @Autowired
  private WebApplicationContext context;

  private MockMvc mockMvc;

  private ObjectMapper objectMapper;

  @BeforeEach
  void setUp() {
    mockMvc = MockMvcBuilders.webAppContextSetup(this.context).build();
    objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());
  }

  @Test
  void shouldGetAllCustomers() throws Exception {
    MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/customers"))
                                 .andExpect(MockMvcResultMatchers.status().isOk())
                                 .andReturn();

    MockHttpServletResponse response = mvcResult.getResponse();
    String content = response.getContentAsString();

    RestResponse restResponse = objectMapper.readValue(content, RestResponse.class);

    boolean success = restResponse.isSuccess();
    assertTrue(success);
  }
}