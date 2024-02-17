package com.bahadirmemis.n11bootcamp2.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

/**
 * @author bahadirmemis
 */
@Entity
@Data
public class Book {

  @Id
  private Long id;
  private String name;
}
