package com.br.books4u.domain.book;

import com.br.books4u.domain.author.Author;
import com.br.books4u.domain.bookLocalization.BookLocalization;
import com.br.books4u.domain.genre.Genre;
import com.br.books4u.domain.publisher.Publisher;
import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "tb_books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    private String CDD;
    private String CDU;
    private String CUTER;

    @Column(columnDefinition = "boolean default true")
    private Boolean active;

    @Column(nullable = false)
    private String status;

    @Column(nullable = false)
    private Integer copy;

    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinColumn(name = "genre_id")
    @JoinTable(
            name = "tb_books_genres",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    private List<Genre> genres;

    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;

    @ManyToOne
    @JoinColumn(name = "books_localization_id")
    private BookLocalization bookLocalization;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "tb_books_authors",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    private List<Author> authors;
}
