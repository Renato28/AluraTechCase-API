package br.com.alura.api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

@Entity(name = "Student")
@Table(name = "students")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Student extends User implements Serializable {

    @CPF
    @NotNull
    private String cpf;

    @Temporal(TemporalType.DATE)
    @NotNull
    private LocalDate birthDate;

    @ManyToMany(mappedBy = "students")
    private Set<Course> courses;
}
