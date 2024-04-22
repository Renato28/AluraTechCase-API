package br.com.alura.api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import java.io.Serializable;
import java.time.LocalDate;

@Entity(name = "Instructor")
@Table(name = "instructors")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Instructor extends User implements Serializable {

    @CPF
    @NotNull
    private String cpf;

    @Temporal(TemporalType.DATE)
    @NotNull
    @Column(name = "birth_date")
    private LocalDate birthDate;
}
