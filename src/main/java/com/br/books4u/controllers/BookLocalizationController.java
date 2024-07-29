package com.br.books4u.controllers;

import com.br.books4u.domain.bookLocalization.BookLocalization;
import com.br.books4u.domain.bookLocalization.BookLocalizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/bookLocalization")
public class BookLocalizationController {

    @Autowired
    private BookLocalizationService bookLocalizationService;

    @GetMapping("/")
    public ResponseEntity<List<BookLocalization>> getAllBookLocalization() {
        return ResponseEntity.ok(bookLocalizationService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<BookLocalization>> getBookLocalizationById(@PathVariable Long id) {
        return ResponseEntity.ok(bookLocalizationService.findById(id));
    }

    @PostMapping
    public ResponseEntity<BookLocalization> saveBookLocalization(@RequestBody BookLocalization bookLocalization) {
        return ResponseEntity.ok(bookLocalizationService.save(bookLocalization));
    }

    @PutMapping
    public ResponseEntity<BookLocalization> updateBookLocalization(@RequestBody BookLocalization bookLocalization) {
        return ResponseEntity.ok(bookLocalizationService.save(bookLocalization));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBookLocalization(@PathVariable Long id) {
        if (bookLocalizationService.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        bookLocalizationService.deleteById(id);
        return ResponseEntity.ok().body("Deletado com sucesso!");
    }
}
