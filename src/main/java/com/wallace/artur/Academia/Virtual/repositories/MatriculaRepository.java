package com.wallace.artur.Academia.Virtual.repositories;


import com.wallace.artur.Academia.Virtual.domain.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MatriculaRepository extends JpaRepository<Matricula, Long> {

    List<Matricula> findByCursoId(Long cursoId);
    List<Matricula> findByAlunoId(Long alunoId);
}
