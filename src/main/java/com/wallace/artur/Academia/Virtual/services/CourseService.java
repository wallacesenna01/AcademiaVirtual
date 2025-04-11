package com.wallace.artur.Academia.Virtual.services;

import com.wallace.artur.Academia.Virtual.domain.Course;
import com.wallace.artur.Academia.Virtual.dtos.CourseDTO;
import com.wallace.artur.Academia.Virtual.dtos.CourseUpdateDTO;
import com.wallace.artur.Academia.Virtual.repositories.CourseRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<CourseUpdateDTO> listar() {
        return courseRepository.findAll().stream().map(course -> new CourseUpdateDTO(
                course.getId(),
                course.getName(),
                course.getCategory(),
                course.getDescription()
        )).toList();
    }

    public CourseDTO save(CourseDTO dto) {
        Course course = new Course();
        course.setName(dto.name());
        course.setDescription(dto.description());
        course.setCategory(dto.category());
        course.setCreateAt(LocalDateTime.now());

        Course saved = courseRepository.save(course);

        return new CourseDTO(
                saved.getName(),
                saved.getDescription(),
                saved.getCategory()
                );
    }

    public Course findById(Long id) {
        return courseRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Course Not Found"));
    }

    public void delete(Long id) {

        Course course = courseRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Curso com o id"  + id + "não encontrado"));

       courseRepository.delete(course);
    }

    public CourseUpdateDTO update(CourseUpdateDTO course, Long id) {

        Course existingCourse = courseRepository.findById(id)
                        .orElseThrow(() -> new EntityNotFoundException("Course with " + course.id() + " not found"));
        existingCourse.setName(course.name());
        existingCourse.setCategory(course.category());
        existingCourse.setDescription(course.description());
        Course updatedCourse = courseRepository.save(existingCourse);

        return new CourseUpdateDTO(updatedCourse.getId(),updatedCourse.getName(), updatedCourse.getCategory(), updatedCourse.getDescription());
    }
}
