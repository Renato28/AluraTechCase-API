package br.com.alura.api.dto;

import br.com.alura.api.model.Course;

import java.time.LocalDate;

public record CourseDTO(Long id, String name, String code, String instructor, String description,
                        LocalDate dateCreation, LocalDate inactivationDate) {

    public CourseDTO(Course course) {
        this(course.getId(), course.getName(), course.getCode(), course.getInstructor(), course.getDescription(), course.getDateCreation(), course.getInactivationDate());
    }
}
