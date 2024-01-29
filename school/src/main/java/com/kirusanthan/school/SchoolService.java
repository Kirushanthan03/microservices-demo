package com.kirusanthan.school;

import com.kirusanthan.school.client.StudentClient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SchoolService {
    private final SchoolRepository schoolRepository;
    private final StudentClient client;

    public School saveSchool(School school) {

        return schoolRepository.save(school);
    }

    public ResponseEntity<List<School>> findAllSchools() {

        return ResponseEntity.ok(schoolRepository.findAll());
    }


    public FullResponseEntity findAllSchoolsWithStudents(Integer schoolId) {
        School found = schoolRepository.findById(schoolId).orElse(School.builder().name("Not_Found").email("Not_Found").build());
        List<STUDENT> students =client.findAllStudentsBySchool(schoolId);

        FullResponseEntity response = FullResponseEntity.builder().
        name(found.getName())
                .email(found.getEmail())
                .students(students)
                .build();

        return response;
    }
}
