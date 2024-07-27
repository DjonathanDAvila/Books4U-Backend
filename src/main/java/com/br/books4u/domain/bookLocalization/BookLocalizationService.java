package com.br.books4u.domain.bookLocalization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookLocalizationService {
    @Autowired
    private BookLocalizationRepository bookLocalizationRepository;
}
