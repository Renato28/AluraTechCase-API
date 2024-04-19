package br.com.alura.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record RegistrationRequestDTO(@NotNull Long idCourse, @NotNull Long idUser, @NotBlank LocalDate registrationDate) {
}
