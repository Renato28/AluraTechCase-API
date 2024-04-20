package br.com.alura.api.service;

import br.com.alura.api.dto.RegisterUserDTO;
import br.com.alura.api.dto.UserDTO;
import br.com.alura.api.model.User;
import br.com.alura.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void registerUser(RegisterUserDTO data ) {
        userRepository.save(new User(data));
    }

    public Optional<UserDTO> getRegisteredUserData(String username) {
        Optional<UserDTO> user = userRepository.getRegisteredUserData(username);
        return user.map(u -> new UserDTO(u.name(), u.email(), u.role()));
    }
}
