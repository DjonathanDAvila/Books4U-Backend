package com.br.books4u.domain.publisher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PublisherService {
    @Autowired
    private PublisherRepository publisherRepository;

    @Transactional(readOnly = true)
    public List<Publisher> findAll() {
        return publisherRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Publisher> findById(Long id) {
        return publisherRepository.findById(id);
    }

    @Transactional(readOnly = true)
    public List<Publisher> findByName(String name) {
        return publisherRepository.findByNameContaining(name);
    }

    public Publisher save(Publisher publisher) {
        return publisherRepository.save(publisher);
    }

    public void delete(Long id) {
        publisherRepository.deleteById(id);
    }
}
