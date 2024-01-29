package com.kirusanthan.student;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public Student saveStudent(Student student) {

        return studentRepository.save(student);
    }

    public ResponseEntity<List<Student>> findAllStudents() {

        return ResponseEntity.ok(studentRepository.findAll());
    }

    public ResponseEntity<List<Student>> findAllStudentsBySchool( Integer schoolId) {

        return  ResponseEntity.ok(studentRepository.findAllBySchoolID(schoolId));
    }
}
