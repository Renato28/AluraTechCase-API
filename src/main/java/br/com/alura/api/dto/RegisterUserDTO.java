package br.com.alura.api.dto;

import br.com.alura.api.model.Role;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record RegisterUserDTO(
        @NotBlank String name,
        @NotBlank String username,
        @NotBlank String email,
        @NotBlank String password,
        @NotBlank Role role,
        @NotBlank LocalDate dateCreation
        ) {
}
