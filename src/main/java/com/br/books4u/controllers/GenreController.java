package com.br.books4u.controllers;

import com.br.books4u.domain.genre.Genre;
import com.br.books4u.domain.genre.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/genre")
public class GenreController {
    @Autowired
    private GenreService genreService;

    @GetMapping("/")
    public ResponseEntity<List<Genre>> listAll() {
        return ResponseEntity.ok(genreService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Genre>> findById(@PathVariable long id) {
        return ResponseEntity.ok(genreService.findById(id));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<Genre>> findByName(@PathVariable String name) {
        return ResponseEntity.ok(genreService.findGenreByName(name));
    }

    @PostMapping
    public ResponseEntity<Genre> save(@RequestBody Genre genre) {
        return ResponseEntity.ok(genreService.save(genre));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable long id) {
        if (genreService.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        genreService.delete(id);
        return ResponseEntity.ok().body("Genero deletado com sucesso!");
    }
}
