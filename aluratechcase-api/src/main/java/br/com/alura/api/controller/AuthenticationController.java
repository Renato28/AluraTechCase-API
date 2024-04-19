package br.com.alura.api.controller;

import br.com.alura.api.dto.AuthenticationData;
import br.com.alura.api.model.User;
import br.com.alura.api.security.DataTokenJWT;
import br.com.alura.api.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity login(@RequestBody @Valid AuthenticationData data) {
        try {
            var authenticationToken = new UsernamePasswordAuthenticationToken(data.username(), data.password());
            var authentication = manager.authenticate(authenticationToken);

            var token = tokenService.generateToken((User) authentication.getPrincipal());

            return ResponseEntity.ok(new DataTokenJWT(token));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}