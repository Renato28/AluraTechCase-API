package br.com.alura.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class RegisterUserDTO {

        @NotBlank String name;
        @NotBlank String username;
        @NotBlank String email;
        @NotBlank String password;
        @NotBlank String role;
        @NotNull LocalDate dateCreation;

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public String getUsername() {
                return username;
        }

        public void setUsername(String username) {
                this.username = username;
        }

        public String getEmail() {
                return email;
        }

        public void setEmail(String email) {
                this.email = email;
        }

        public String getPassword() {
                return password;
        }

        public void setPassword(String password) {
                this.password = password;
        }

        public String getRole() {
                return role;
        }

        public void setRole(String role) {
                this.role = role;
        }

        public LocalDate getDateCreation() {
                return dateCreation;
        }

        public void setDateCreation(LocalDate dateCreation) {
                this.dateCreation = dateCreation;
        }
}

