package com.bahadirmemis.n11bootcamp2;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author bahadirmemis
 */
class TrainingTest {

  //@BeforeAll
  //@BeforeEach
  //@AfterAll
  //@AfterEach

  @BeforeAll
  static void beforeAll(){
    System.out.println("BeforeAll");
  }

  @BeforeEach
  void beforeEach(){
    System.out.println("BeforeEach");
  }

  @AfterAll
  static void afterAll(){
    System.out.println("AfterAll");
  }

  @AfterEach
  void afterEach(){
    System.out.println("AfterEach");
  }

  @Test
  void test1(){
    System.out.println("test1");
  }

  @Test
  void test2(){
    System.out.println("test2");
  }
}
