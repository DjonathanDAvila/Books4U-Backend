package com.br.books4u.domain.loan.dtos;

import jakarta.validation.constraints.NotBlank;

import java.util.Date;

public record LoanSaveDTO(
        Long id,
        @NotBlank
        Date startDate,
        @NotBlank
        Date endDate,
        Date deliveredDate,
        Double tax,
        Long bookId,
        Long studentId
) {
}
