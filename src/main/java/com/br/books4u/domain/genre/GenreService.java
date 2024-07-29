package com.br.books4u.domain.genre;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class GenreService {
    @Autowired
    private GenreRepository genreRepository;

    @Transactional(readOnly = true)
    public Optional<Genre> findById(Long id) {
        return genreRepository.findById(id);
    }

    @Transactional(readOnly = true)
    public List<Genre> findAll() {
        return genreRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<Genre> findGenreByName(String name) {
        return genreRepository.findGenreByName(name);
    }

    public Genre save(Genre genre) {
        return genreRepository.save(genre);
    }

    public void delete(Long id) {
        genreRepository.deleteById(id);
    }
}
