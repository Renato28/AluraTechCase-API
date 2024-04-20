package br.com.alura.api.service;

import br.com.alura.api.dto.RegisterUserDTO;
import br.com.alura.api.dto.UserDTO;
import br.com.alura.api.model.User;
import br.com.alura.api.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void registerUser(RegisterUserDTO data ) {
        userRepository.save(new User(data));
    }

    public List<UserDTO> listUserRegisteredBy(String username) {
        return userRepository.findByUsernameContains(username);
    }
}
