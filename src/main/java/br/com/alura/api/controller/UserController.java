package br.com.alura.api.controller;

import br.com.alura.api.dto.RegisterUserDTO;
import br.com.alura.api.dto.UserDTO;
import br.com.alura.api.model.User;
import br.com.alura.api.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping
    @Transactional
    public ResponseEntity<?> registerUser(@RequestBody @Valid RegisterUserDTO data) {

        User user = new User();

        String ecriptedPassword = bCryptPasswordEncoder.encode(data.password());

        user.setUsername(data.username());
        user.setPassword(ecriptedPassword);

        this.userService.registerUser(data);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/{username}")
    public ResponseEntity<List<UserDTO>> listUserRegisteredBy(@PathVariable String username) {
        List<UserDTO> user = userService.listUserRegisteredBy(username);
        if (user.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok().body(user);
        }
    }

}
