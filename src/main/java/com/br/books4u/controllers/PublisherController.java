package com.br.books4u.controllers;

import com.br.books4u.domain.publisher.Publisher;
import com.br.books4u.domain.publisher.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/publisher")
public class PublisherController {
    @Autowired
    private PublisherService publisherService;

    @GetMapping("/")
    public ResponseEntity<List<Publisher>> getAllPublishers(){
        return ResponseEntity.ok(publisherService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Publisher>> getPublisherById(@PathVariable Long id){
        return ResponseEntity.ok(publisherService.findById(id));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<Publisher>> getPublisherByName(@PathVariable String name){
        return ResponseEntity.ok(publisherService.findByName(name));
    }

    @PostMapping
    public ResponseEntity<Publisher> savePublisher(@RequestBody Publisher publisher){
        return ResponseEntity.ok(publisherService.save(publisher));
    }

    @PutMapping
    public ResponseEntity<Publisher> updatePublisher(@RequestBody Publisher publisher){
        return ResponseEntity.ok(publisherService.save(publisher));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePublisher(@PathVariable Long id){
        if (publisherService.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        publisherService.delete(id);
        return ResponseEntity.ok().body("Editora deletada com sucesso!");
    }
}
