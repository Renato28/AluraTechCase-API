package br.com.alura.api.controller;

import br.com.alura.api.dto.CourseDTO;
import br.com.alura.api.dto.RegisterCourseDTO;
import br.com.alura.api.service.CourseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping
    @Transactional
    public void registerCourse(@RequestBody @Valid RegisterCourseDTO data) {
        this.courseService.registerCourse(data);
    }

    @GetMapping
    public Page<CourseDTO> getCourseList(@RequestParam(name = "status", required = false) Boolean status, Pageable pageable) {
        return courseService.getCoursesList(status, pageable);
    }

    @PutMapping("/{code}")
    @Transactional
    public ResponseEntity<String> disableCourse(@PathVariable String code) {

        CourseDTO course = courseService.getCourseByCode(code);

        this.courseService.disableCourse(course.code());
        return ResponseEntity.ok().build();
    }
}
