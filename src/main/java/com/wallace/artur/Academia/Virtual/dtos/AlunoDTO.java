package com.wallace.artur.Academia.Virtual.dtos;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record AlunoDTO(
        Long id,
        String name,
        String email,
        String cpf,
        LocalDate birthDate,
        String phone,
        LocalDateTime registrationDate,
        Boolean active
) {
}
