package br.com.alura.api.repository;

import br.com.alura.api.model.Course;
import br.com.alura.api.model.Registration;
import br.com.alura.api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationRepository extends JpaRepository<Registration, Long> {

    boolean existsByUserAndCourse(User user, Course course);
}
