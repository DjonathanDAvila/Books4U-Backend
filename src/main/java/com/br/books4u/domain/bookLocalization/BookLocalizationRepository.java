package com.br.books4u.domain.bookLocalization;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookLocalizationRepository extends JpaRepository<BookLocalization, Long> {
}
