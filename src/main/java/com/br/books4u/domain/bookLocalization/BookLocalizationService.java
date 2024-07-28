package com.br.books4u.domain.bookLocalization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class BookLocalizationService {
    @Autowired
    private BookLocalizationRepository bookLocalizationRepository;

    @Transactional(readOnly = true)
    public List<BookLocalization> findAll() {
        return bookLocalizationRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<BookLocalization> findById(Long id) {
        return bookLocalizationRepository.findById(id);
    }

    public BookLocalization save(BookLocalization bookLocalization) {
        return bookLocalizationRepository.save(bookLocalization);
    }

    public void deleteById(Long id) {
        bookLocalizationRepository.deleteById(id);
    }
}
