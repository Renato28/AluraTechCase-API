package br.com.alura.api.service;

import br.com.alura.api.dto.RegisterUserDTO;
import br.com.alura.api.dto.UserDTO;
import br.com.alura.api.model.User;
import br.com.alura.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
