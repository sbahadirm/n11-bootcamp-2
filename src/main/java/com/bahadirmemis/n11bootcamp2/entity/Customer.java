package com.bahadirmemis.n11bootcamp2.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author bahadirmemis
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Customer {

  private Long id;
  private String name;
  private String surname;

  // @NoArgsConstructor
  //public Customer() {
  //}

  //@AllArgsConstructor
  //public Customer(Long id, String name, String surname) {
  //  this.id = id;
  //  this.name = name;
  //  this.surname = surname;
  //}

  //public Long getId() {
  //  return id;
  //}
  //
  //public String getName() {
  //  return name;
  //}
  //
  //public String getSurname() {
  //  return surname;
  //}

  //public void setId(Long id) {
  //  this.id = id;
  //}
  //
  //public void setName(String name) {
  //  this.name = name;
  //}
  //
  //public void setSurname(String surname) {
  //  this.surname = surname;
  //}
}
