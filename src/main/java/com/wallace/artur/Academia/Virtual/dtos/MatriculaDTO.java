package com.wallace.artur.Academia.Virtual.dtos;

import java.time.LocalDateTime;

public record MatriculaDTO(
        Long id,
        Long alunoId,
        String alunoNome,
        Long cursoId,
        String cursoNome,
        LocalDateTime dataMatricula

) {
}
