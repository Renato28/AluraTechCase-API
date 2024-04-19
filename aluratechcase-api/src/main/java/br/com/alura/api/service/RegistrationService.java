package br.com.alura.api.service;

import br.com.alura.api.dto.RegistrationRequestDTO;
import br.com.alura.api.exception.RegistrationException;
import br.com.alura.api.model.Course;
import br.com.alura.api.model.Registration;
import br.com.alura.api.model.User;
import br.com.alura.api.repository.CourseRepository;
import br.com.alura.api.repository.RegistrationRepository;
import br.com.alura.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    @Autowired
    private RegistrationRepository registrationRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CourseRepository courseRepository;

    public void requestRegistration(RegistrationRequestDTO dto) {

        Course course = courseRepository.getReferenceById(dto.idCourse());

        User user = userRepository.getReferenceById(dto.idUser());

        if (!course.getAtivo()) {

            throw new RegistrationException("It is not possible to enroll in a course that is not active.");
        }

        boolean isAlreadyRegistered = registrationRepository.existsByUserAndCourse(user, course);

        if (isAlreadyRegistered) {

            throw new RegistrationException("It is not possible to enroll in the same course again.");
        }

        registrationRepository.save(new Registration());
    }
}
