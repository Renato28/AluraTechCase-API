package br.com.alura.api.controller;

import br.com.alura.api.dto.EvaluateCourseDTO;
import br.com.alura.api.service.EvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/evaluations")
public class EvaluationController {

    @Autowired
    private EvaluationService evaluationService;

    @PostMapping("/evaluate-course")
    public ResponseEntity<Void> evaluateCourse(@RequestBody EvaluateCourseDTO data) {
        evaluationService.evaluateCourse(data);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
