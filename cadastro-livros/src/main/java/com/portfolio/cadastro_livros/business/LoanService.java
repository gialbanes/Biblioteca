package com.portfolio.cadastro_livros.business;

import com.portfolio.cadastro_livros.infrastructure.dtos.LoanDTO;
import com.portfolio.cadastro_livros.infrastructure.entitys.Book;
import com.portfolio.cadastro_livros.infrastructure.entitys.Loan;
import com.portfolio.cadastro_livros.infrastructure.entitys.User;
import com.portfolio.cadastro_livros.infrastructure.repository.BookRepository;
import com.portfolio.cadastro_livros.infrastructure.repository.LoanRepository;
import com.portfolio.cadastro_livros.infrastructure.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoanService {
    @Autowired
    private final LoanRepository loanRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookRepository bookRepository;

    public LoanService(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    public void saveLoan(LoanDTO dto){
        User user = userRepository.findById(dto.getUser_id())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        Book book = bookRepository.findById(dto.getBook_id())
                .orElseThrow(() -> new RuntimeException("Livro não encontrado"));

        Loan loan = Loan.builder()
                .user(user)
                .book(book)
                .dateLoan(dto.getDateLoan())
                .dateReturn(dto.getDateReturn())
                .status(dto.getStatus())
                .expectedReturnDate(dto.getExpectedReturnDate())
                .lateFee(dto.getLateFee())
                .build();

        loanRepository.save(loan);
    }

    public Loan findLoanById(Long id){
        return loanRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Empréstimo não encontrado.")
        );
    }

    public void updateLoan(Long id, Loan loan){
        Loan loanEntity = loanRepository.findById(id).orElseThrow(
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
        loanRepository.save(loanUpdated);
    }

    public void deleteLoan(Long id){
        loanRepository.deleteById(id);
    }
}
