package com.bahadirmemis.n11bootcamp2.entity;

import com.bahadirmemis.n11bootcamp2.enums.EnumState;
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
 * Hibernate: create table customer
 * (birth_date date,
 * state smallint check (state between 0 and 1),
 * id bigint not null,
 * email varchar(255),
 * identity_no varchar(255),
 * password varchar(255),
 * phone_number varchar(255),
 * surname varchar(255),
 * username varchar(255),
 * primary key (id))
 *
 * * name not null varchar(100),
 *
 *
 *
 * Hibernate: create table customer
 * (birth_date date,
 * id bigint not null,
 * identity_no varchar(11),
 * phone_number varchar(20),
 * state varchar(30) not null check (state in ('PASSIVE','ACTIVE')),
 * email varchar(100) not null,
 * name varchar(100) not null,
 * surname varchar(100) not null,
 * username varchar(100) not null,
 * password varchar(400) not null,
 * primary key (id))
 *
 * @author bahadirmemis
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "CUSTOMER")
public class Customer {

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
