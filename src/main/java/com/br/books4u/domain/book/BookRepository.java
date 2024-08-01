package com.br.books4u.domain.book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findBookByTitleContaining(String title);

    List<Book> findByAuthors_NameContaining(String authorName);

    List<Book> findByGenres_NameContaining(String genreName);
}
