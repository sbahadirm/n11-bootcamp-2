package com.bahadirmemis.n11bootcamp2.entity;

import com.bahadirmemis.n11bootcamp2.enums.EnumAccountType;
import com.bahadirmemis.n11bootcamp2.enums.EnumCurrencyType;
import com.bahadirmemis.n11bootcamp2.enums.EnumStatus;
import com.bahadirmemis.n11bootcamp2.general.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;

/**
 * @author bahadirmemis
 */
@Entity
@Table(name = "ACCOUNT")
@Getter
@Setter
public class Account extends BaseEntity {

  @SequenceGenerator(name = "Account", sequenceName = "ACCOUNT_ID_SEQ")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Account")
  @Id
  private Long id;

  @Column(name = "IBAN_NO", length = 30)
  private String ibanNo;

  @Column(name = "CURRENT_BALANCE", precision = 19, scale = 2)
  private BigDecimal currentBalance;

  @Enumerated(EnumType.STRING)
  @Column(name = "ACCOUNT_TYPE", length = 30)
  private EnumAccountType accountType;

  @Enumerated(EnumType.STRING)
  @Column(name = "CURRENCY_TYPE", length = 30)
  private EnumCurrencyType currencyType;

  @Enumerated(EnumType.STRING)
  @Column(name = "STATUS", length = 30)
  private EnumStatus status;
}
