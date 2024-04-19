package br.com.alura.api.controller;

import br.com.alura.api.dto.RegistrationRequestDTO;
import br.com.alura.api.service.RegistrationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/registrations")
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    @PostMapping
    @Transactional
    public ResponseEntity<String> requestRegistration(@RequestBody @Valid RegistrationRequestDTO data) {
        this.registrationService.requestRegistration(data);
        return ResponseEntity.ok("Matricula realizada com sucesso!");
    }
}
