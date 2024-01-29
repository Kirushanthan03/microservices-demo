package com.kirusanthan.student;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public  Student saveStudent(@RequestBody Student student){
        return studentService.saveStudent(student);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.FOUND)
    public ResponseEntity<List<Student>> findAllStudents(){
        return studentService.findAllStudents();
    }

    @GetMapping("school/{schoolId}")
    @ResponseStatus(HttpStatus.FOUND)
    public ResponseEntity<List<Student>> findAllStudentsBySchool(@PathVariable("schoolId") Integer schoolId){

        return studentService.findAllStudentsBySchool(schoolId);
    }
}
