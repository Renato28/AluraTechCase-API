package br.com.alura.api.service;

import br.com.alura.api.dto.CourseDTO;
import br.com.alura.api.dto.RegisterCourseDTO;
import br.com.alura.api.exception.CourseException;
import br.com.alura.api.model.Course;
import br.com.alura.api.model.Role;
import br.com.alura.api.repository.CourseRepository;
import br.com.alura.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private UserRepository userRepository;

    public List<CourseDTO> getAll() {
        return courseRepository.findAll().stream().map(CourseDTO::new).toList();
    }

    public void registerCourse(RegisterCourseDTO data) {

        CourseDTO instructor = courseRepository.findByInstructor(data.instructor());

        if (!instructor.instructor().equals(Role.INSTRUCTOR)) {
            throw new CourseException("Apenas usuários instrutores podem ser autores de um curso.");
        }

        courseRepository.save(new Course(data));
    }

    public CourseDTO getCourseByCode(String code) {

        return courseRepository.findByCode(code);
    }

    public Page<CourseDTO> getCoursesList(boolean status, Pageable pageable) {

        return courseRepository.findAllByAtivoTrue(status, pageable);
    }

    public void disableCourse(String code) {
        Course course = courseRepository.getReferenceById(Long.valueOf(code));
        course.disableCourse();
        course.setInactivationDate(LocalDate.now());
    }

}
