package com.br.books4u.domain.student;

import com.br.books4u.domain.classroom.Classroom;
import com.br.books4u.domain.classroom.ClassroomRepository;
import com.br.books4u.domain.classroom.ClassroomService;
import com.br.books4u.domain.student.dtos.StudentSaveDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ClassroomRepository classroomRepository;

    @Transactional(readOnly = true)
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Student> findById(Long id) {
        return studentRepository.findById(id);
    }

    @Transactional(readOnly = true)
    public List<Student> findByName(String name) {
        return studentRepository.findByfullnameContaining(name);
    }

    public Student save(StudentSaveDTO studentSaveDTO) {
        Classroom classroom = classroomRepository.findById(studentSaveDTO.classroomId())
                .orElseThrow(() -> new RuntimeException("Classroom not found"));

        Student student = new Student();
        student.setFullname(studentSaveDTO.fullname());
        student.setEnrollment(studentSaveDTO.enrollment());
        student.setActive(studentSaveDTO.active());
        student.setClassroom(classroom);

        return studentRepository.save(student);
    }

    public void delete(Long id) {
        studentRepository.deleteById(id);
    }
}
