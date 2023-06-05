package com.lpa.app.controller.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.NoArgsConstructor;

import java.util.Set;

public record CreateUserDTO(

    @Email
    @NotBlank
    String email,
    @NotBlank
    String username,
    @NotBlank
    String password,
    Set<String> roles

) {
}
