package com.bahadirmemis.n11bootcamp2.request;

import jakarta.validation.constraints.NotBlank;

/**
 * @author bahadirmemis
 */
public record CustomerUpdatePasswordRequest(@NotBlank String oldPass,
                                            @NotBlank String newPass,
                                            @NotBlank String newPass2) {

}