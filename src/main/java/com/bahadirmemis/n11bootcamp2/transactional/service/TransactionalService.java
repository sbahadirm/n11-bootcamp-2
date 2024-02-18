package com.bahadirmemis.n11bootcamp2.transactional.service;

import com.bahadirmemis.n11bootcamp2.entity.Customer;
import com.bahadirmemis.n11bootcamp2.service.entityservice.CustomerEntityService;
import com.bahadirmemis.n11bootcamp2.transactional.util.TransactionalUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Bahadır Memiş
 * @since 1.0.0
 */
@Service
@Transactional
@RequiredArgsConstructor
public class TransactionalService {

  private final CustomerEntityService customerEntityService;

  private final NonTransactionalService nonTransactionalService;

  private final TransactionalService2 transactionalService2;

  private final TransactionalConstantService transactionalConstantService;

  private final NonTransactionalConstantService nonTransactionalConstantService;

  public void save() {

    Customer customer = TransactionalUtil.getDummyCustomer("ts2");

    customerEntityService.save(customer);

    System.out.println("end");
  }

  public void saveT2N() {

    Customer customer = TransactionalUtil.getDummyCustomer("ts3");

    customerEntityService.save(customer);

    nonTransactionalService.save();

    System.out.println("end");
  }

  public void saveT2T() {

    Customer customer = TransactionalUtil.getDummyCustomer("ts5");

    customerEntityService.save(customer);

    save();

    System.out.println("end");
  }

  public void saveButError() {

    Customer customer = TransactionalUtil.getDummyCustomer("ts6");

    customerEntityService.save(customer);

    //throwException();

    try {
      throwException();
    } catch (Exception e) {
      e.printStackTrace();
    }

    System.out.println("end");
  }

  private void throwException() {
    throw new RuntimeException("error");
  }

  /**
   * https://stackoverflow.com/questions/28480480/propagation-requires-new-does-not-create-a-new-transaction-in
   * -spring-with-jpa
   *
   * Spring transactions are proxy-based. Here's thus how it works when bean A causes a transactional
   * of bean B. A has in fact a reference to a proxy, which delegates to the bean B.
   * This proxy is the one which starts and commits/rollbacks the transaction:
   *
   * A ---> proxy ---> B
   * In your code, a transactional method of A calls another transactional method of A.
   * So Spring can't intercept the call and start a new transaction.
   * It's a regular method call without any proxy involved.
   *
   * So, if you want a new transaction to start, the method createSampleObject() should be in another bean,
   * injected into your current bean.
   */
  public void saveT2RN() {

    Customer customer = TransactionalUtil.getDummyCustomer("ts8-1");

    customerEntityService.save(customer);

    saveRN();

    System.out.println("end");
  }

  @Transactional(propagation = Propagation.REQUIRES_NEW)
  public void saveRN() {

    Customer customer = TransactionalUtil.getDummyCustomer("ts8-2");

    customerEntityService.save(customer);

    System.out.println("end");
  }

  public void saveT2RNWithDifferentBean() {

    Customer customer = TransactionalUtil.getDummyCustomer("ts9-1");

    customerEntityService.save(customer);

    transactionalService2.saveRN();

    System.out.println("end");
  }

  public void saveT2RNButError() {

    Customer customer = TransactionalUtil.getDummyCustomer("ts10");

    customerEntityService.save(customer);

    for (int i = 0; i < 10; i++) {
      try {
        transactionalService2.saveRN(i);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }

    System.out.println("end");
  }

  public void saveT2TButError() {

    Customer customer = TransactionalUtil.getDummyCustomer("ts10");

    customerEntityService.save(customer);

    for (int i = 0; i < 10; i++) {
      try {
        transactionalService2.save(i);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }

    System.out.println("end");
  }

  @Transactional(propagation = Propagation.MANDATORY)
  public void saveMandatory() {

    Customer customer = TransactionalUtil.getDummyCustomer("ts11-T");

    customerEntityService.save(customer);

    System.out.println("end");
  }

  public void saveT2M() {

    Customer customer = TransactionalUtil.getDummyCustomer("ts12-T");

    customerEntityService.save(customer);

    transactionalService2.saveMandatory();

    System.out.println("end");
  }

  public void saveT2S() {

    Customer customer = TransactionalUtil.getDummyCustomer("ts12-T");

    customerEntityService.save(customer);

    transactionalService2.saveSupports();

    System.out.println("end");
  }

  @Transactional(propagation = Propagation.NOT_SUPPORTED)
  public void doSomething() {

    for (int i = 0; i < 9999; i++) {
      Customer customer = transactionalConstantService.findById(1L);
    }
  }

  public void saveNested() {

    transactionalService2.saveNested();

    System.out.println("end");
  }

  public void doSomethingWithNewTransaction() {

    for (int i = 0; i < 9999; i++) {
      Customer customer = transactionalConstantService.findByIdWithNewTransaction(1L);
    }
  }

  public void saveT2Never() {

    Customer customer = TransactionalUtil.getDummyCustomer("ts21-Non");

    customerEntityService.save(customer);

    nonTransactionalConstantService.saveNever();

    System.out.println("end");
  }
}
