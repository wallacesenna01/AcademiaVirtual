package com.wallace.artur.Academia.Virtual.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public record ProfessorCreateDTO(String name, String email, String phone, String speciality,@JsonFormat(pattern = "dd/MM/yyyy") LocalDate hireDate) {
}
