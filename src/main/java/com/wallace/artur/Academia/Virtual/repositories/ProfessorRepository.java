package com.wallace.artur.Academia.Virtual.repositories;

import com.wallace.artur.Academia.Virtual.domain.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
}
