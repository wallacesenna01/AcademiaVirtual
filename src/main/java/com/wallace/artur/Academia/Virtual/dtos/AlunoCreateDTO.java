package com.wallace.artur.Academia.Virtual.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public record AlunoCreateDTO(
        String name,
        String email,
        String cpf,
        @JsonFormat(pattern = "yyyy-MM-dd")
        LocalDate birthday,
        String phone
) {
}
