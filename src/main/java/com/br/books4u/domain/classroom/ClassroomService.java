package com.br.books4u.domain.classroom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ClassroomService {
    @Autowired
    private ClassroomRepository classroomRepository;

    @Transactional(readOnly = true)
    public List<Classroom> findAll() {
        return classroomRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Classroom> findById(Long id) {
        return classroomRepository.findById(id);
    }

    public Classroom save(Classroom classroom) {
        return classroomRepository.save(classroom);
    }

    public void deleteById(Long id) {
        classroomRepository.deleteById(id);
    }
}
