package com.br.books4u.domain.student.dtos;

import jakarta.validation.constraints.NotBlank;

public record StudentSaveDTO(
        @NotBlank
        String fullname,
        @NotBlank
        Long enrollment,
        Boolean active,
        Long classroomId
) {
}
