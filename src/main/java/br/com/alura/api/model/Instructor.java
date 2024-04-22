package br.com.alura.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
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
    private LocalDate birthDate;
}
