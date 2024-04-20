package br.com.alura.api.dto;

import br.com.alura.api.model.Role;
import br.com.alura.api.model.User;

public record UserDTO(String name, String email, String role) {
    public UserDTO(User user) {
        this(user.getName(), user.getEmail(), user.getRole());
    }
}
