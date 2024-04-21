package br.com.alura.api.model;

import br.com.alura.api.dto.RegisterCourseDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@Table(name = "courses")
@Entity(name = "Course")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Course implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Size(max = 10, message = "O codigo deve ter no máximo 20 caracteres")
    @Column(unique = true)
    @Pattern(regexp = "^[a-zA-Z]+(?:-[a-zA-Z]+)*$", message = "O código do curso deve ser textual, sem espaços, caracteres numéricos ou especiais, mais pode ser separados por hifens")
    private String code;

    private String instructor;

    private String description;

    @Transient
    private Boolean ativo;

    @Temporal(TemporalType.DATE)
    @Column(name = "creation_date")
    private LocalDate dateCreation;

    @Temporal(TemporalType.DATE)
    @Column(name = "inactivation_date")
    private LocalDate inactivationDate;

    public Course(RegisterCourseDTO data) {
        this.name = data.name();
        this.code = data.code();
        this.instructor = data.instructor();
        this.description = data.description();
        this.dateCreation = data.dateCreation();
        this.inactivationDate = data.inactivationDate();
    }

    public void disableCourse() {
        this.ativo = false;
    }

}
