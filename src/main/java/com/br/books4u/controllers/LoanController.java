package com.br.books4u.controllers;

import com.br.books4u.domain.loan.Loan;
import com.br.books4u.domain.loan.LoanService;
import com.br.books4u.domain.loan.dtos.LoanSaveDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/loan")
public class LoanController {

    @Autowired
    private LoanService loanService;

    @GetMapping("/")
    public ResponseEntity<List<Loan>> findAll() {
        return ResponseEntity.ok(loanService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Loan>> findById(@PathVariable Long id) {
        return ResponseEntity.ok(loanService.findById(id));
    }

    @GetMapping("/student/{name}")
    public ResponseEntity<List<Loan>> findByStudentName(@PathVariable String name) {
        return ResponseEntity.ok(loanService.findByStudentName(name));
    }

    @GetMapping("/book/{title}")
    public ResponseEntity<List<Loan>> findByBookTitle(@PathVariable String title) {
        return ResponseEntity.ok(loanService.findByBookTitle(title));
    }

    @GetMapping("/startDate/{start}/endDate/{end}")
    public ResponseEntity<List<Loan>> getLoansByStartDateRange(
            @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date start,
            @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date end) {

        List<Loan> loans = loanService.findByStartDateBetween(start, end);
        return ResponseEntity.ok(loans);
    }

    @GetMapping("/endDate/{start}/endDate/{end}")
    public ResponseEntity<List<Loan>> getLoansByEndDateRange(
            @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date start,
            @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date end) {

        List<Loan> loans = loanService.findByEndDateBetween(start, end);
        return ResponseEntity.ok(loans);
    }

    @PostMapping
    public ResponseEntity<Loan> save(@RequestBody LoanSaveDTO loanSaveDTO) {
        Loan saveLoan = loanService.save(loanSaveDTO);
        return ResponseEntity.ok(saveLoan);
    }

    @PutMapping
    public ResponseEntity<Loan> update(@RequestBody LoanSaveDTO loanSaveDTO) {
        Loan saveLoan = loanService.save(loanSaveDTO);
        return ResponseEntity.ok(saveLoan);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        if (loanService.findById(id).isPresent()) {
            loanService.deleteById(id);
            return ResponseEntity.ok("Deletado com sucesso!");
        }

        return ResponseEntity.notFound().build();
    }
}
