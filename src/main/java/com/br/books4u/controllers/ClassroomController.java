package com.br.books4u.controllers;

import com.br.books4u.domain.classroom.Classroom;
import com.br.books4u.domain.classroom.ClassroomService;
import com.br.books4u.domain.genre.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
    @RequestMapping("/classroom")
public class ClassroomController {
    @Autowired
    private ClassroomService classroomService;

    @GetMapping("/")
    public ResponseEntity<List<Classroom>> findAllClassrooms() {
        return ResponseEntity.ok(classroomService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Classroom>> findClassroomById(@PathVariable Long id) {
        return ResponseEntity.ok().body(classroomService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Classroom> saveClassroom(@RequestBody Classroom classroom) {
        return ResponseEntity.ok().body(classroomService.save(classroom));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteClassroomById(@PathVariable Long id) {
        if (classroomService.findById(id).isPresent()) {
            classroomService.deleteById(id);
            return ResponseEntity.ok().body("Classroom deletado com sucesso!");
        }
        return ResponseEntity.notFound().build();
    }
}
