package com.bahadirmemis.n11bootcamp2.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.time.LocalDate;

/**
 * @author bahadirmemis
 */
public record CustomerUpdateRequest(@NotNull @Positive Long id,
                                    @NotBlank String name,
                                    @NotBlank String surname,
                                    @NotNull LocalDate birthDate,
                                    @NotBlank String phoneNumber,
                                    @NotBlank String email) {

}
