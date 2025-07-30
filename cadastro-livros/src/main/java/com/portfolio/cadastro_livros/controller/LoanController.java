package com.portfolio.cadastro_livros.controller;

import com.portfolio.cadastro_livros.business.LoanService;
import com.portfolio.cadastro_livros.infrastructure.dtos.LoanDTO;
import com.portfolio.cadastro_livros.infrastructure.entitys.Loan;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/loan")
@RequiredArgsConstructor
public class LoanController {
    private final LoanService loanService;

    @PostMapping
    public ResponseEntity<Void> saveLoan(@RequestBody LoanDTO loanDTO){
        loanService.saveLoan(loanDTO);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<Loan> findLoanById(@RequestParam Long id){
        loanService.findLoanById(id);
        return ResponseEntity.ok(loanService.findLoanById(id));
    }

    @PutMapping
    public ResponseEntity<Void> updateLoan(@RequestParam Long id, @RequestBody Loan loan){
        loanService.updateLoan(id, loan);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteLoan(@RequestParam Long id){
        loanService.deleteLoan(id);
        return ResponseEntity.ok().build();
    }
}
