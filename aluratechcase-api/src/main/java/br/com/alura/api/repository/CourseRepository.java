package br.com.alura.api.repository;

import br.com.alura.api.dto.CourseDTO;
import br.com.alura.api.model.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    Page<CourseDTO> findAllByAtivoTrue(boolean status, Pageable pageable);

    CourseDTO findByInstructor(String instructor);

    CourseDTO findByCode(String code);
}
