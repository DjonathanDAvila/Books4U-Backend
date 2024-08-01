package com.br.books4u.domain.loan;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {
    List<Loan> findByStudent_fullnameContaining(String userName);

    List<Loan> findByBooks_titleContaining(String userName);

    List<Loan> findByStartDateBetween(Date start, Date end);

    List<Loan> findByEndDateBetween(Date start, Date end);
}
