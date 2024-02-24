package com.bahadirmemis.n11bootcamp2.controller.contract.impl;

import com.bahadirmemis.n11bootcamp2.dto.CustomerDTO;
import com.bahadirmemis.n11bootcamp2.entity.Customer;
import com.bahadirmemis.n11bootcamp2.errormessage.CustomerErrorMessage;
import com.bahadirmemis.n11bootcamp2.general.N11BusinessException;
import com.bahadirmemis.n11bootcamp2.request.CustomerUpdatePasswordRequest;
import com.bahadirmemis.n11bootcamp2.request.CustomerUpdateRequest;
import com.bahadirmemis.n11bootcamp2.service.entityservice.CustomerEntityService;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author bahadirmemis
 */
@ExtendWith(MockitoExtension.class)
class CustomerControllerContractImplTest {

  @Mock
  private CustomerEntityService customerEntityService;

  @InjectMocks
  private CustomerControllerContractImpl customerControllerContractImpl;

  @Captor
  private ArgumentCaptor<Customer> customerArgumentCaptor;

  @Test
  void shouldGetAllCustomers() {

    //given
    Customer customer1 = new Customer();
    customer1.setName("name1");
    customer1.setSurname("surname1");
    Customer customer2 = new Customer();
    customer2.setName("name2");
    customer2.setSurname("surname2");
    Customer customer3 = new Customer();
    customer3.setName("name3");
    customer3.setSurname("surname3");
    Customer customer4 = new Customer();
    customer4.setName("name4");
    customer4.setSurname("surname4");
    List<Customer> customers = new ArrayList<>();
    customers.add(customer1);
    customers.add(customer2);
    customers.add(customer3);
    customers.add(customer4);

    //when
    Mockito.when(customerEntityService.findAll()).thenReturn(customers);

    List<CustomerDTO> results = customerControllerContractImpl.getAllCustomers();

    //then
    assertEquals(customers.size(), results.size());

    for (int i = 0; i < results.size(); i++) {
      CustomerDTO result = results.get(i);
      Customer eachCustomer = customers.get(i);

      assertEquals(eachCustomer.getName(), result.name());
      assertEquals(eachCustomer.getSurname(), result.surname());
    }
  }

  @Test
  void shouldGetCustomerById() {

    //given
    Long id = 18L;
    String name = "name1";
    String surname = "surname1";
    Customer customer = new Customer();
    customer.setId(id);
    customer.setName(name);
    customer.setSurname(surname);

    //when
    Mockito.when(customerEntityService.findByIdWithControl(Mockito.anyLong())).thenReturn(customer);

    CustomerDTO result = customerControllerContractImpl.getCustomerById(19L);

    //then

    assertEquals(id, result.id());
    assertEquals(name, result.name());
    assertEquals(surname, result.surname());
  }

  @Test
  void shouldUpdateCustomer() {

    //given
    CustomerUpdateRequest request = new CustomerUpdateRequest(1L, "Bahadır", "Memiş",
                                                              LocalDate.of(1991, 10, 5),
                                                              "5468447654", "sbahadirm@gmail.com");

    Long id = 18L;
    String name = "name1";
    String surname = "surname1";
    Customer customer = new Customer();
    customer.setId(id);
    customer.setName(name);
    customer.setSurname(surname);

    //when
    Mockito.when(customerEntityService.findByIdWithControl(Mockito.anyLong())).thenReturn(customer);
    Mockito.doNothing()
           .when(customerEntityService)
           .testVoidMethod(Mockito.anyLong(), Mockito.anyString(), Mockito.any(Customer.class));

    CustomerDTO result = customerControllerContractImpl.updateCustomer(request);

    //then
    InOrder inOrder = Mockito.inOrder(customerEntityService);
    inOrder.verify(customerEntityService).findByIdWithControl(request.id());
    inOrder.verify(customerEntityService).testVoidMethod(request.id(), request.name(), customer);
    inOrder.verify(customerEntityService).save(customer);
    inOrder.verifyNoMoreInteractions();

    assertEquals(id, result.id());
    assertEquals(request.name(), result.name());
    assertEquals(request.surname(), result.surname());
    assertEquals(request.birthDate(), result.birthDate());
    assertEquals(request.phoneNumber(), result.phoneNumber());
    assertEquals(request.email(), result.email());
  }

  @Test
  void shouldUpdateCustomerPassword(){

    //given
    Long id = 18L;
    String oldPass = "1231231234";
    String newPass = "12312312345";
    String newPass2 = "12312312345";
    CustomerUpdatePasswordRequest request = new CustomerUpdatePasswordRequest(oldPass, newPass, newPass2);

    Customer customer = new Customer();
    customer.setId(id);
    customer.setName("name");
    customer.setSurname("surname");
    customer.setPassword(oldPass);

    //when
    Mockito.when(customerEntityService.findByIdWithControl(Mockito.anyLong())).thenReturn(customer);

    CustomerDTO result = customerControllerContractImpl.updateCustomerPassword(id, request);

    //then
    InOrder inOrder = Mockito.inOrder(customerEntityService);
    inOrder.verify(customerEntityService).findByIdWithControl(id);
    inOrder.verify(customerEntityService).save(customerArgumentCaptor.capture());
    inOrder.verifyNoMoreInteractions();

    Customer customerArgumentCaptorValue = customerArgumentCaptor.getValue();
    assertEquals(newPass, customerArgumentCaptorValue.getPassword());

    assertEquals(id, result.id());
    assertEquals(customer.getName(), result.name());
    assertEquals(customer.getSurname(), result.surname());
  }

  @Test
  void shouldNotUpdateCustomerPasswordWhenOldPassIsWrong(){

    //given
    Long id = 18L;
    String oldPass = "1231231234";
    String newPass = "12312312345";
    String newPass2 = "12312312345";
    CustomerUpdatePasswordRequest request = new CustomerUpdatePasswordRequest(oldPass, newPass, newPass2);

    Customer customer = new Customer();
    customer.setId(id);
    customer.setName("name");
    customer.setSurname("surname");
    customer.setPassword("oldPass");

    //when
    Mockito.when(customerEntityService.findByIdWithControl(Mockito.anyLong())).thenReturn(customer);

    N11BusinessException n11BusinessException = assertThrows(N11BusinessException.class,
                                                             () -> customerControllerContractImpl.updateCustomerPassword(
                                                                 id, request));
    assertEquals(CustomerErrorMessage.INVALID_OLD_PASSWORD, n11BusinessException.getBaseErrorMessage());
  }

  @Test
  void shouldNotUpdateCustomerPasswordWhenNewPasswordsAreDifferent(){

    //given
    Long id = 18L;
    String oldPass = "1231231234";
    String newPass = "1231231234";
    String newPass2 = "12312312345";
    CustomerUpdatePasswordRequest request = new CustomerUpdatePasswordRequest(oldPass, newPass, newPass2);

    Customer customer = new Customer();
    customer.setId(id);
    customer.setName("name");
    customer.setSurname("surname");
    customer.setPassword(oldPass);

    //when
    Mockito.when(customerEntityService.findByIdWithControl(Mockito.anyLong())).thenReturn(customer);

    N11BusinessException n11BusinessException = assertThrows(N11BusinessException.class,
                                                             () -> customerControllerContractImpl.updateCustomerPassword(
                                                                 id, request));
    assertEquals(CustomerErrorMessage.NEW_PASSWORDS_DID_NOT_MATCH, n11BusinessException.getBaseErrorMessage());
  }
}