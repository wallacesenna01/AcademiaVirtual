package com.wallace.artur.Academia.Virtual.repositories;

import com.wallace.artur.Academia.Virtual.domain.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}
