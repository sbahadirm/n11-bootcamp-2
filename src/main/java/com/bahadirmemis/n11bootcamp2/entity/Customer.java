package com.bahadirmemis.n11bootcamp2.entity;

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
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

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

  @NotNull
  @Length(min = 1, max = 100)
  @Column(name = "NAME", length = 100, nullable = false)
  private String name;

  @NotNull
  @Length(min = 1, max = 100)
  @Column(name = "SURNAME", length = 100, nullable = false)
  private String surname;

  @Past
  @Column(name = "BIRTH_DATE")
  private LocalDate birthDate; // locateDate:05.10.1991 - localtime: 10:15:67 - localDateTime: 05.10.1991 10:15:67

  @NotBlank
  @Column(name = "USERNAME", length = 100, nullable = false)
  private String username;

  @NotBlank
  @Column(name = "IDENTITY_NO", length = 11)
  private String identityNo;

  @NotBlank(message = "PASSWORD CANNOT BE BLANK!!!")
  @Column(name = "PASSWORD", length = 400, nullable = false)
  private String password;

  @Column(name = "PHONE_NUMBER", length = 20)
  private String phoneNumber;

  @Email
  @NotBlank
  @Column(name = "EMAIL", length = 100, nullable = false)
  private String email;

  @NotNull
  @Enumerated(EnumType.STRING)
  @Column(name = "STATUS", length = 30, nullable = false)
  private EnumStatus status;
}
