package com.bahadirmemis.n11bootcamp2.request;

import java.time.LocalDate;

/**
 * @author bahadirmemis
 */
public record CustomerSaveRequest(String nameXXX,
                                  String surname,
                                  LocalDate birthDate,
                                  String username,
                                  String identityNo,
                                  String password,
                                  String phoneNumber,
                                  String email) {

}
