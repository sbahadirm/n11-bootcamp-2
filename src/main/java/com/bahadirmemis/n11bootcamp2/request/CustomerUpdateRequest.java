package com.bahadirmemis.n11bootcamp2.request;

import java.time.LocalDate;

/**
 * @author bahadirmemis
 */
public record CustomerUpdateRequest(Long id,
                                    String name,
                                    String surname,
                                    LocalDate birthDate,
                                    String phoneNumber,
                                    String email) {

}
