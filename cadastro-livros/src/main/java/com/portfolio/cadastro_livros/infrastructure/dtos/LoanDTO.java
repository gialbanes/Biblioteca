package com.portfolio.cadastro_livros.infrastructure.dtos;

import lombok.Data;

import java.time.LocalDate;

@Data
public class LoanDTO {
    private Long user_id;
    private Long book_id;
    private LocalDate dateLoan;
    private LocalDate dateReturn;
    private String status;
    private LocalDate expectedReturnDate;
    private Double lateFee;
}
