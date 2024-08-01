package com.br.books4u.domain.book.dtos;

import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record BookSaveDTO(
        @NotBlank
        String title,
        String CDD,
        String CDU,
        String CUTER,
        Boolean active,
        @NotBlank
        String status,
        Integer copy,
        List<Long> genresId,
        Long publisherId,
        Long bookLocalizationId,
        List<Long> authorsIds
) {
}
