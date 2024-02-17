package com.bahadirmemis.n11bootcamp2.request;

import com.bahadirmemis.n11bootcamp2.entity.BookDTO;
import java.time.LocalDate;
import java.util.List;

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
                                  String email,
                                  List<BookDTO> books) {

}
