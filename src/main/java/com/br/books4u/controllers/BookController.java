package com.br.books4u.controllers;

import com.br.books4u.domain.book.Book;
import com.br.books4u.domain.book.BookService;
import com.br.books4u.domain.book.dtos.BookSaveDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/")
    public ResponseEntity<List<Book>> findAll() {
        return ResponseEntity.ok(bookService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Book>> findById(@PathVariable Long id) {
        return ResponseEntity.ok(bookService.findById(id));
    }

    @GetMapping("/title/{title}")
    public ResponseEntity<List<Book>> findBookByTitleContaining(@PathVariable String title) {
        return ResponseEntity.ok(bookService.findBookByTitleContaining(title));
    }

    @GetMapping("/author/{authorName}")
    public ResponseEntity<List<Book>> findByAuthors_NameContaining(@PathVariable String authorName) {
        return ResponseEntity.ok(bookService.findByAuthors_NameContaining(authorName));
    }

    @GetMapping("/genre/{genreName}")
    public ResponseEntity<List<Book>> findByGenre_NameContaining(@PathVariable String genreName) {
        return ResponseEntity.ok(bookService.findByGenre_NameContaining(genreName));
    }

    @PostMapping
    public ResponseEntity<Book> saveBook(@RequestBody BookSaveDTO bookSaveDTO) {
        Book saveBook = bookService.save(bookSaveDTO);
        return ResponseEntity.ok(saveBook);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable Long id) {
        if (bookService.findById(id).isPresent()) {
            bookService.delteBookById(id);
            return ResponseEntity.ok().body("Book deletado com sucesso");
        }

        return ResponseEntity.notFound().build();
    }
}
