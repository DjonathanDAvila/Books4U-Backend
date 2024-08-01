package com.br.books4u.domain.book;

import com.br.books4u.domain.author.Author;
import com.br.books4u.domain.author.AuthorRepository;
import com.br.books4u.domain.book.dtos.BookSaveDTO;
import com.br.books4u.domain.bookLocalization.BookLocalization;
import com.br.books4u.domain.bookLocalization.BookLocalizationRepository;
import com.br.books4u.domain.genre.Genre;
import com.br.books4u.domain.genre.GenreRepository;
import com.br.books4u.domain.publisher.Publisher;
import com.br.books4u.domain.publisher.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private GenreRepository genreRepository;

    @Autowired
    private PublisherRepository publisherRepository;

    @Autowired
    private BookLocalizationRepository bookLocalizationRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Transactional(readOnly = true)
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

    @Transactional(readOnly = true)
    public List<Book> findBookByTitleContaining(String title) {
        return bookRepository.findBookByTitleContaining(title);
    }

    @Transactional(readOnly = true)
    public List<Book> findByAuthors_NameContaining(String authorName) {
        return bookRepository.findByAuthors_NameContaining(authorName);
    }

    @Transactional(readOnly = true)
    public List<Book> findByGenre_NameContaining(String genreName) {
        return bookRepository.findByGenres_NameContaining(genreName);
    }

    public Book save(BookSaveDTO bookSaveDTO) {
        List<Genre> genres = genreRepository.findAllById(bookSaveDTO.genresId());
        if (genres.size() != bookSaveDTO.genresId().size()) {
            throw new RuntimeException("Genres and genres do not match");
        }

        Publisher publisher = publisherRepository.findById(bookSaveDTO.publisherId())
                .orElseThrow(() -> new RuntimeException("Publisher not found"));

        BookLocalization bookLocalization = bookLocalizationRepository.findById(bookSaveDTO.bookLocalizationId())
                .orElseThrow(() -> new RuntimeException("BookLocalization not found"));

        List<Author> authors = authorRepository.findAllById(bookSaveDTO.authorsIds());
        if (authors.size() != bookSaveDTO.authorsIds().size()) {
            throw new RuntimeException("One or more authors not found");
        }

        Book book = new Book();
        book.setTitle(bookSaveDTO.title());
        book.setCDD(bookSaveDTO.CDD());
        book.setCDU(bookSaveDTO.CDU());
        book.setCUTER(bookSaveDTO.CUTER());
        book.setActive(bookSaveDTO.active());
        book.setStatus(bookSaveDTO.status());
        book.setCopy(bookSaveDTO.copy());
        book.setGenres(genres);
        book.setPublisher(publisher);
        book.setBookLocalization(bookLocalization);
        book.setAuthors(authors);

        return bookRepository.save(book);
    }

    public void delteBookById(Long id) {
        bookRepository.deleteById(id);
    }
}
