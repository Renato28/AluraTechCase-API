package br.com.alura.api.dto;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record RegistrationCourseDTO(
        @NotBlank String name,
        @NotBlank String code,
        @NotBlank String instructor,
        @NotBlank String description,
        @NotBlank LocalDate dateCreatiom,
        @NotBlank LocalDate inactivationDate
) {
}
