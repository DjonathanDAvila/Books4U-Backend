package com.br.books4u.controllers;

import com.br.books4u.domain.student.Student;
import com.br.books4u.domain.student.StudentService;
import com.br.books4u.domain.student.dtos.StudentSaveDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/")
    public ResponseEntity<List<Student>> finAll() {
        return ResponseEntity.ok(studentService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Student>> findById(@PathVariable Long id) {
        return ResponseEntity.ok(studentService.findById(id));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<Student>> findByName(@PathVariable String name) {
        return ResponseEntity.ok(studentService.findByName(name));
    }

    @PostMapping
    public ResponseEntity<Student> save(@RequestBody StudentSaveDTO studentSaveDTO) {
        Student savedStudent = studentService.save(studentSaveDTO);
        return ResponseEntity.ok(savedStudent);
    }

    @PutMapping
    public ResponseEntity<Student> update(@RequestBody StudentSaveDTO studentSaveDTO) {
        Student savedStudent = studentService.save(studentSaveDTO);
        return ResponseEntity.ok(savedStudent);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        if (studentService.findById(id).isPresent()) {
            studentService.delete(id);
            return ResponseEntity.ok().body("Deletado com sucesso");
        }
        return ResponseEntity.noContent().build();
    }
}
