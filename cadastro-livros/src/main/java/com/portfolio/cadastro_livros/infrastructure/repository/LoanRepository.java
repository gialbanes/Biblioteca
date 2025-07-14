package com.portfolio.cadastro_livros.infrastructure.repository;

import com.portfolio.cadastro_livros.infrastructure.entitys.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepository extends JpaRepository<Loan, Integer> {
}
