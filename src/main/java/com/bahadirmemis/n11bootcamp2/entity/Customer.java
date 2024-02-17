package com.bahadirmemis.n11bootcamp2.entity;

import com.bahadirmemis.n11bootcamp2.enums.EnumState;
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
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * id, createdAt, createdBy, updatedAt, updatedBy
 *
 * @author bahadirmemis
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "CUSTOMER")
public class Customer extends BaseEntity {

  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Customer")
  @SequenceGenerator(name = "Customer", sequenceName = "CUSTOMER_ID_SEQ")
  @Id
  private Long id;

  @Column(name = "NAME", length = 100, nullable = false)
  private String name;

  @Column(name = "SURNAME", length = 100, nullable = false)
  private String surname;

  @Column(name = "BIRTH_DATE")
  private LocalDate birthDate; // locateDate:05.10.1991 - localtime: 10:15:67 - localDateTime: 05.10.1991 10:15:67

  @Column(name = "USERNAME", length = 100, nullable = false)
  private String username;

  @Column(name = "IDENTITY_NO", length = 11)
  private String identityNo;

  @Column(name = "PASSWORD", length = 400, nullable = false)
  private String password;

  @Column(name = "PHONE_NUMBER", length = 20)
  private String phoneNumber;

  @Column(name = "EMAIL", length = 100, nullable = false)
  private String email;

  @Enumerated(EnumType.STRING)
  @Column(name = "STATE", length = 30, nullable = false)
  private EnumState state;
}
