package com.bahadirmemis.n11bootcamp2.controller;

import com.bahadirmemis.n11bootcamp2.N11Bootcamp2Application;
import com.bahadirmemis.n11bootcamp2.request.CustomerSaveRequest;
import com.bahadirmemis.n11bootcamp2.request.CustomerUpdatePasswordRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
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
class CustomerControllerTest extends BaseControllerTest {

  @Autowired
  private WebApplicationContext context;

  private MockMvc mockMvc;

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

    boolean success = isSuccess(mvcResult);
    assertTrue(success);
  }

  @Test
  void shouldSaveCustomer() throws Exception {

    String requestAsString = "{\n"
                             + "  \"nameXXX\": \"controllertest\",\n"
                             + "  \"surname\": \"string\",\n"
                             + "  \"birthDate\": \"2024-02-24\",\n"
                             + "  \"username\": \"string\",\n"
                             + "  \"identityNo\": \"string\",\n"
                             + "  \"password\": \"string\",\n"
                             + "  \"phoneNumber\": \"string\",\n"
                             + "  \"email\": \"string@mail.com\"\n"
                             + "}";

    MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/customers")
                                                                .content(requestAsString)
                                                                .contentType(MediaType.APPLICATION_JSON))
                                 .andExpect(MockMvcResultMatchers.status().isOk())
                                 .andReturn();

    boolean success = isSuccess(mvcResult);
    assertTrue(success);
  }

  @Test
  void shouldSaveCustomer2() throws Exception {

    CustomerSaveRequest request =
        new CustomerSaveRequest("controllertest2", "surname", LocalDate.now(), "username", "34738434", "pass", "phone",
                                "email");

    String requestAsString = objectMapper.writeValueAsString(request);

    MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/customers")
                                                                .content(requestAsString)
                                                                .contentType(MediaType.APPLICATION_JSON))
                                 .andExpect(MockMvcResultMatchers.status().isOk())
                                 .andReturn();

    boolean success = isSuccess(mvcResult);
    assertTrue(success);
  }

  @Test
  void shouldGetByIdCustomers() throws Exception {
    MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/customers/1001"))
                                 .andExpect(MockMvcResultMatchers.status().isOk())
                                 .andReturn();

    boolean success = isSuccess(mvcResult);
    assertTrue(success);
  }

  @Test
  void shouldUpdatePassword() throws Exception {

    CustomerUpdatePasswordRequest request  = new CustomerUpdatePasswordRequest("123", "1234", "1234");
    String requestAsString = objectMapper.writeValueAsString(request);

    MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.patch("/api/v1/customers/1002/password")
                                                                .content(requestAsString)
                                                                .contentType(MediaType.APPLICATION_JSON))
                                 .andExpect(MockMvcResultMatchers.status().isOk())
                                 .andReturn();

    boolean success = isSuccess(mvcResult);

    assertTrue(success);
  }
}