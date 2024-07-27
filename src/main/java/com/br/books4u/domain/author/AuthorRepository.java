package com.br.books4u.domain.author;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    @Query("SELECT a from Author a WHERE a.name like %:name%")
    Optional<List<Author>> findAuthorByNameLike(@Param("name") String name);
}
