package com.kirusanthan.school;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/school")
@RequiredArgsConstructor
public class SchoolController {

    private final SchoolService schoolService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public School saveSchool(@RequestBody School school){
        return schoolService.saveSchool(school);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.FOUND)
    public ResponseEntity<List<School>> findAllSchools(){
        return schoolService.findAllSchools();
    }

    @GetMapping("schools/{schoolId}")
    @ResponseStatus(HttpStatus.FOUND)
    public FullResponseEntity findAllSchoolsWithStudents(@PathVariable Integer schoolId)
    {
        return schoolService.findAllSchoolsWithStudents(schoolId);
    }
}
