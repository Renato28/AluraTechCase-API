package br.com.alura.api.model;

import br.com.alura.api.dto.RegisterCourseDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "courses")
public class Course implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Size(max = 20, message = "O codigo deve ter no máximo 20 caracteres")
    @Column(unique = true)
    @Pattern(regexp = "^[a-zA-Z]+(?:-[a-zA-Z]+)*$", message = "O código do curso deve ser textual, sem espaços, caracteres numéricos ou especiais, mais pode ser separados por hifens")
    private String code;

    private String instructor;

    private String description;

    private Boolean ativo;

    @Temporal(TemporalType.DATE)
    private LocalDate dateCreation;

    @Temporal(TemporalType.DATE)
    private LocalDate inactivationDate;

    public Course(RegisterCourseDTO data) {
        this.name = data.name();
        this.code = data.code();
        this.instructor = data.instructor();
        this.description = data.description();
        this.ativo = true;
        this.dateCreation = data.dateCreatiom();
        this.inactivationDate = data.inactivationDate();
    }

    public void disableCourse() {
        this.ativo = false;
    }

    public Course() {

    }

    public Course(Long id, String name, String code, String instructor, String description, Boolean ativo, LocalDate dateCreation, LocalDate inactivationDate) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.instructor = instructor;
        this.description = description;
        this.ativo = ativo;
        this.dateCreation = dateCreation;
        this.inactivationDate = inactivationDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public LocalDate getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(LocalDate dateCreation) {
        this.dateCreation = dateCreation;
    }

    public LocalDate getInactivationDate() {
        return inactivationDate;
    }

    public void setInactivationDate(LocalDate inactivationDate) {
        this.inactivationDate = inactivationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return Objects.equals(id, course.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
