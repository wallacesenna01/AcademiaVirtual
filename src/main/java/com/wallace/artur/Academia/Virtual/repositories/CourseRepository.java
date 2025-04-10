package com.wallace.artur.Academia.Virtual.repositories;

import com.wallace.artur.Academia.Virtual.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CourseRepository extends JpaRepository<Course, Long> {

    Optional<Course> findByName(String name);
}
