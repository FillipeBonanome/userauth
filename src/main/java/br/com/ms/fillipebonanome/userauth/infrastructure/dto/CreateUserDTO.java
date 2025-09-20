package br.com.ms.fillipebonanome.userauth.infrastructure.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateUserDTO(
        @NotBlank @Size(min = 6)
        String username,
        @NotBlank
        String name,
        @NotBlank @Size(min = 8)
        String password,
        @NotBlank @Email
        String email
) {
}
