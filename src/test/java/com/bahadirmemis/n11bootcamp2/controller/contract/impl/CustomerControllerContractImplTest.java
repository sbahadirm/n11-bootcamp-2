package com.bahadirmemis.n11bootcamp2.controller.contract.impl;

import com.bahadirmemis.n11bootcamp2.dto.CustomerDTO;
import com.bahadirmemis.n11bootcamp2.entity.Customer;
import com.bahadirmemis.n11bootcamp2.service.CalculatorService;
import com.bahadirmemis.n11bootcamp2.service.entityservice.CustomerEntityService;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author bahadirmemis
 */
@ExtendWith(MockitoExtension.class)
class CustomerControllerContractImplTest {

  @Mock
  private CustomerEntityService customerEntityService;

  @InjectMocks
  private CustomerControllerContractImpl customerControllerContractImpl;

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

    for (int i = 0; i < results.size(); i++){
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

    CustomerDTO customerDTO = customerControllerContractImpl.getCustomerById(19L);

    //then

    assertEquals(id, customerDTO.id());
    assertEquals(name, customerDTO.name());
    assertEquals(surname, customerDTO.surname());
  }
}