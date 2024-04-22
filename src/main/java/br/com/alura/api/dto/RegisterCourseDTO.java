package br.com.alura.api.dto;

import br.com.alura.api.model.Instructor;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record RegisterCourseDTO(
        @NotBlank String name,
        @NotBlank String code,
        @NotBlank Instructor instructor,
        @NotBlank String description,
        @NotNull LocalDate dateCreation,
        LocalDate inactivationDate
) {
}
