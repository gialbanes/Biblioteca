package com.portfolio.cadastro_livros.business;

import com.portfolio.cadastro_livros.infrastructure.entitys.Loan;
import com.portfolio.cadastro_livros.infrastructure.repository.LoanRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class LoanService {
    private final LoanRepository repository;

    public LoanService(LoanRepository repository) {
        this.repository = repository;
    }

    public void saveLoan(Loan loan){
        repository.save(loan);
    }

    public Loan findLoanById(Long id){
        return repository.findById(id).orElseThrow(
                () -> new RuntimeException("Empréstimo não encontrado.")
        );
    }

    public void updateLoan(Long id, Loan loan){
        Loan loanEntity = repository.findById(id).orElseThrow(
                () -> new RuntimeException("Empréstimo não encontrado.")
        );
        Loan loanUpdated = Loan.builder()
                .id(loanEntity.getId())
                .user(loan.getUser() != null ? loan.getUser() : loanEntity.getUser())
                .book(loan.getBook() != null ? loan.getBook() : loanEntity.getBook())
                .dateLoan(loan.getDateLoan() != null ? loan.getDateLoan() : loanEntity.getDateLoan())
                .dateReturn(loan.getDateReturn() != null ? loan.getDateReturn() : loanEntity.getDateReturn())
                .status(loan.getStatus() != null ? loan.getStatus() : loanEntity.getStatus())
                .expectedReturnDate(loan.getExpectedReturnDate() != null ? loan.getExpectedReturnDate() : loanEntity.getExpectedReturnDate())
                .lateFee(loan.getLateFee() != null ? loan.getLateFee() : loanEntity.getLateFee())
                .build();
        repository.save(loanUpdated);
    }

    public void deleteLoan(Long id){
        repository.deleteById(id);
    }
}
