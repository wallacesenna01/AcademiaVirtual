package com.wallace.artur.Academia.Virtual.dtos;

import jakarta.validation.constraints.NotBlank;

public record CourseDTO(@NotBlank String name, @NotBlank String description,@NotBlank String category) {
}
