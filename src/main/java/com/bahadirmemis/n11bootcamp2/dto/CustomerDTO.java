package com.bahadirmemis.n11bootcamp2.dto;

import com.bahadirmemis.n11bootcamp2.enums.EnumState;
import java.time.LocalDate;

/**
 * @author bahadirmemis
 */
public record CustomerDTO(Long id,
                          String name,
                          String surname,
                          LocalDate birthDate,
                          String username,
                          String identityNo,
                          String phoneNumber,
                          String email,
                          EnumState state) {

}
