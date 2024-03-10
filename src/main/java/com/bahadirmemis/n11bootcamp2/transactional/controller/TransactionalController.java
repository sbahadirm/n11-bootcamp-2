package com.bahadirmemis.n11bootcamp2.transactional.controller;

import com.bahadirmemis.n11bootcamp2.transactional.service.NonTransactionalService;
import com.bahadirmemis.n11bootcamp2.transactional.service.TransactionalService;
import io.swagger.v3.oas.annotations.Operation;
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

  @Operation(summary = "Transactional olmayan yerde kayıt işlemi")
  @PostMapping("/ts1")
  public void ts1() {
    nonTransactionalService.save();
  }

  @Operation(summary = "Transactional olan yerde kayıt işlemi")
  @PostMapping("/ts2")
  public void ts2() {
    transactionalService.save();
    System.out.println("end");
  }

  @Operation(summary = "Transactional olan yerden olmayan yere geçme")
  @PostMapping("/ts3")
  public void ts3() {
    transactionalService.saveT2N();
    System.out.println("end");
  }

  @Operation(summary = "Transactional olmayan yerden olan yere geçme")
  @PostMapping("/ts4")
  public void ts4() {
    nonTransactionalService.saveN2T();
    System.out.println("end");
  }

  @Operation(summary = "İkisi de transactional olan bir yerde kayıt işlemi")
  @PostMapping("/ts5")
  public void ts5() {
    transactionalService.saveT2T();
  }

  @Operation(summary = "Sadece transactional olan bir yerde kayıt işlemi sırasında hata")
  @PostMapping("/ts6")
  public void ts6() {
    transactionalService.saveButError();
  }

  @Operation(summary = "Non transactional olan bir yerde kayıt işlemi sırasında hata")
  @PostMapping("/ts7")
  public void ts7() {
    nonTransactionalService.saveButError();
  }

  @Operation(summary = "Aynı class içinde requires new kullanımı")
  @PostMapping("/ts8")
  public void ts8() {
    transactionalService.saveT2RN();
  }

  @Operation(summary = "Requires new'ı farklı classa taşıma")
  @PostMapping("/ts9")
  public void ts9() {
    transactionalService.saveT2RNWithDifferentBean();
  }

  @Operation(summary = "Requires new ile hata almayanları commitleme")
  @PostMapping("/ts10")
  public void ts10() {
    transactionalService.saveT2RNButError();
  }

  @Operation(summary = "Mandatory transaction yok")
  @PostMapping("/ts11")
  public void ts11() {
    nonTransactionalService.saveN2M();
  }

  @Operation(summary = "Mandatory transaction var")
  @PostMapping("/ts12")
  public void ts12() {
    transactionalService.saveT2M();
  }

  @Operation(summary = "Supports transaction var")
  @PostMapping("/ts13")
  public void ts13() {
    transactionalService.saveT2S();
  }

  @Operation(summary = "Supports transaction yok")
  @PostMapping("/ts14")
  public void ts14() {
    nonTransactionalService.saveN2S();
  }

  @Operation(summary = "Not_supported (hızlı)")
  @PostMapping("/ts15")
  public void ts15() {
    transactionalService.doSomething();
  }

  @Operation(summary = "Nested (desteklenmez)")
  @PostMapping("/ts16")
  public void ts16() {
    transactionalService.saveNested();
  }

  @Operation(summary = "Toplu işlemlerinizi transactional olmayan yerde yapın. En hızlı senaryo")
  @PostMapping("/ts17")
  public void ts17() {
    nonTransactionalService.doSomething();
  }

  @Operation(summary = "Required ile toplu kayıtta hata aldırma")
  @PostMapping("/ts18")
  public void ts18() {
    transactionalService.saveT2TButError();
  }

  @Operation(summary = "Transaction açıp kapatma maliyeti")
  @PostMapping("/ts19")
  public void ts19() {
    transactionalService.doSomethingWithNewTransaction();
  }

  @Operation(summary = "Never - öncesinde transaction yok")
  @PostMapping("/ts20")
  public void ts20() {
    nonTransactionalService.saveNon2Never();
  }

  @Operation(summary = "Never - öncesinde transaction var")
  @PostMapping("/ts21")
  public void ts21() {
    transactionalService.saveT2Never();
  }

}
