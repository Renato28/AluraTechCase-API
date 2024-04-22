package br.com.alura.api.model;

import br.com.alura.api.dto.EvaluateCourseDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Entity(name = "Evaluation")
@Table(name = "evaluations")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Evaluation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private double grade;

    @NotBlank
    private String comments;

    @NotBlank
    @Column(name = "email_instructor")
    private String emailInstructor;

    @Temporal(TemporalType.DATE)
    @NotNull
    @Column(name = "evaluation_date")
    private LocalDate evaluationDate;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "reason_grade")
    private String reasonGrade;

    public Evaluation(EvaluateCourseDTO data) {
        this.grade = data.grade();
        this.comments = data.comments();
        this.evaluationDate = data.evaluationDate();
        this.emailInstructor = data.emailInstrutor();
        this.reasonGrade = data.reasonGrade();
    }
}
