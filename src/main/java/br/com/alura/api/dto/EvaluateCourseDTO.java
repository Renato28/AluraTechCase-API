package br.com.alura.api.dto;

import br.com.alura.api.model.Course;
import br.com.alura.api.model.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record EvaluateCourseDTO(@NotNull Long IdCourse, @NotNull Long idStudent, @NotBlank String emailInstrutor, double grade, @NotBlank String comments, @NotNull LocalDate evaluationDate, @NotBlank String reasonGrade) {

}
