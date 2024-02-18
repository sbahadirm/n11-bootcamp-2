package com.bahadirmemis.n11bootcamp2.transactional.controller;

import com.bahadirmemis.n11bootcamp2.transactional.service.NonTransactionalService;
import com.bahadirmemis.n11bootcamp2.transactional.service.TransactionalService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Bahadır Memiş
 * @since 1.0.0
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/transactional")
public class TransactionalController {

  private final TransactionalService transactionalService;

  private final NonTransactionalService nonTransactionalService;

  /**
   * 1: transactional olmayan yerde kayıt işlemi
   */
  @PostMapping("/ts1")
  public void ts1() {
    nonTransactionalService.save();
  }

  /**
   * 2: transactional olan yerde kayıt işlemi
   */
  @PostMapping("/ts2")
  public void ts2() {
    transactionalService.save();

    System.out.println("end");
  }

  /**
   * 3: transactional olan yerden olmayan yere geçme
   */
  @PostMapping("/ts3")
  public void ts3() {
    transactionalService.saveT2N();

    System.out.println("end");
  }

  /**
   * 4: transactional olmayan yerden olan yere geçme
   */
  @PostMapping("/ts4")
  public void ts4() {
    nonTransactionalService.saveN2T();

    System.out.println("end");
  }

  /**
   * 5: ikisi de transactional olan bir yerde kayıt işlemi
   */
  @PostMapping("/ts5")
  public void ts5() {
    transactionalService.saveT2T();
  }

  /**
   * 6: sadece transactional olan bir yerde kayıt işlemi sırasında hata
   */
  @PostMapping("/ts6")
  public void ts6() {
    transactionalService.saveButError();
  }

  /**
   * 7: non transactional olan bir yerde kayıt işlemi sırasında hata
   */
  @PostMapping("/ts7")
  public void ts7() {
    nonTransactionalService.saveButError();
  }

  /**
   * 8: aynı class içinde requires new kullanımı.
   */
  @PostMapping("/ts8")
  public void ts8() {
    transactionalService.saveT2RN();
  }

  /**
   * 9: requires new i farklı classa taşıma.
   */
  @PostMapping("/ts9")
  public void ts9() {
    transactionalService.saveT2RNWithDifferentBean();
  }

  /**
   * 10: requires new ile hata almayanları commitleme.
   */
  @PostMapping("/ts10")
  public void ts10() {
    transactionalService.saveT2RNButError();
  }

  /**
   * 11: mandatory transaction yok
   */
  @PostMapping("/ts11")
  public void ts11() {
    nonTransactionalService.saveN2M();
  }

  /**
   * 12: mandatory transaction var
   */
  @PostMapping("/ts12")
  public void ts12() {
    transactionalService.saveT2M();
  }

  /**
   * 13: supports transaction var
   */
  @PostMapping("/ts13")
  public void ts13() {
    transactionalService.saveT2S();
  }

  /**
   * 14: supports transaction yok
   */
  @PostMapping("/ts14")
  public void ts14() {
    nonTransactionalService.saveN2S();
  }

  /**
   * 15: not_suppoted (hızlı)
   */
  @PostMapping("/ts15")
  public void ts15() {
    transactionalService.doSomething();
  }

  /**
   * 16: nested (desteklenmez)
   */
  @PostMapping("/ts16")
  public void ts16() {
    transactionalService.saveNested();
  }

  /**
   * 17: toplu işlemlerinizi transactional olmayan yerde yapın.en hızlı senaryo
   */
  @PostMapping("/ts17")
  public void ts17() {
    nonTransactionalService.doSomething();
  }

  /**
   * 18: required ile toplu kayıtta hata aldırma.
   */
  @PostMapping("/ts18")
  public void ts18() {
    transactionalService.saveT2TButError();
  }

  /**
   * 19: transaction açıp kapatma maliyeti
   */
  @PostMapping("/ts19")
  public void ts19() {
    transactionalService.doSomethingWithNewTransaction();
  }

  /**
   * 20: never - öncesinde transaction yok
   */
  @PostMapping("/ts20")
  public void ts20() {
    nonTransactionalService.saveNon2Never();
  }

  /**
   * 21: never - öncesinde transaction var
   */
  @PostMapping("/ts21")
  public void ts21() {
    transactionalService.saveT2Never();
  }
}
