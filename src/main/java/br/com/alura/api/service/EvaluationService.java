package br.com.alura.api.service;

import br.com.alura.api.dto.EvaluateCourseDTO;
import br.com.alura.api.model.Evaluation;
import br.com.alura.api.repository.EvaluationRepository;
import br.com.alura.api.service.util.EmailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EvaluationService {

    @Autowired
    private EvaluationRepository evaluationRepository;

    public void evaluateCourse(EvaluateCourseDTO data) {
        evaluationRepository.save(new Evaluation(data));
        if (data.grade() < 6) {
            sendInstructorNotification(data);
        }
    }

    private void sendInstructorNotification(EvaluateCourseDTO data) {
        String subject = "Low Rating Received";
        String body = "A student gave the course a low rating. \n" +
                "Reason: " + data.reasonGrade();
        EmailSender.send(data.emailInstrutor(), subject, body);
    }
}
