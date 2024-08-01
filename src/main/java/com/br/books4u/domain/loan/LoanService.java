package com.br.books4u.domain.loan;

import com.br.books4u.domain.book.Book;
import com.br.books4u.domain.book.BookRepository;
import com.br.books4u.domain.loan.dtos.LoanSaveDTO;
import com.br.books4u.domain.student.Student;
import com.br.books4u.domain.student.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class LoanService {
    @Autowired
    private LoanRepository loanRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Transactional(readOnly = true)
    public List<Loan> findAll() {
        return loanRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Loan> findById(Long id) {
        return loanRepository.findById(id);
    }

    @Transactional(readOnly = true)
    public List<Loan> findByStudentName(String studentName) {
        return loanRepository.findByStudent_fullnameContaining(studentName);
    }

    @Transactional(readOnly = true)
    public List<Loan> findByBookTitle(String bookTitle) {
        return loanRepository.findByBooks_titleContaining(bookTitle);
    }

    @Transactional(readOnly = true)
    public List<Loan> findByStartDateBetween(Date start, Date end) {
        return loanRepository.findByStartDateBetween(start, end);
    }

    @Transactional(readOnly = true)
    public List<Loan> findByEndDateBetween(Date start, Date end) {
        return loanRepository.findByEndDateBetween(start, end);
    }

    public Loan save(LoanSaveDTO loanSaveDTO) {
        List<Book> books = bookRepository.findAllById(loanSaveDTO.booksId());
        if (books.size() != loanSaveDTO.booksId().size()) {
            throw new RuntimeException("One or more authors not found");
        }

        Student student = studentRepository.findById(loanSaveDTO.studentId())
                .orElseThrow(() -> new RuntimeException("Student not found"));

        Loan saveLoan;
        if (loanSaveDTO.id() != null) {
            saveLoan = loanRepository.findById(loanSaveDTO.id())
                    .orElseThrow(() -> new RuntimeException("Loan not found"));
        } else {
            saveLoan = new Loan();
        }
        saveLoan.setStartDate(loanSaveDTO.startDate());
        saveLoan.setEndDate(loanSaveDTO.endDate());
        saveLoan.setDeliveredDate(loanSaveDTO.deliveredDate());
        saveLoan.setTax(loanSaveDTO.tax());
        saveLoan.setBooks(books);
        saveLoan.setStudent(student);

        return loanRepository.save(saveLoan);
    }

    public void deleteById(Long id) {
        loanRepository.deleteById(id);
    }
}
