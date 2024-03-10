package com.bahadirmemis.n11bootcamp2.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import java.time.LocalDate;
import org.hibernate.validator.constraints.Length;

/**
 * @author bahadirmemis
 */
public record CustomerSaveRequest(@NotBlank @Length(min = 1, max = 100) String nameXXX,
                                  @NotBlank String surname,
                                  @NotNull @Past LocalDate birthDate,
                                  @NotNull String username,
                                  @NotBlank String identityNo,
                                  @NotBlank String password,
                                  @NotBlank String phoneNumber,
                                  @NotBlank @Email String email) {

}
