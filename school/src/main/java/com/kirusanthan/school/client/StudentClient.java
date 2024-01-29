package com.kirusanthan.school.client;

import com.kirusanthan.school.STUDENT;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@FeignClient(name = "student-service", url = "${application.config.students-url}")
public interface StudentClient {








        @GetMapping("school/{schoolId}")
        List<STUDENT> findAllStudentsBySchool(@PathVariable Integer schoolId);

    }


