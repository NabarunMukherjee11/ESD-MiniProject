package com.backend.ESD.controller;


import com.backend.ESD.model.Courses;
import com.backend.ESD.model.IdRequest;
import com.backend.ESD.repository.CourseRepository;
import com.backend.ESD.repository.StudentRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/courseDetails")
@Getter
@Setter
public class CourseController {
    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private StudentRepository studentRepository;

    @PostMapping
    public ResponseEntity<?> getCourseDetails(@RequestBody IdRequest idRequest){
        try{
            Optional<Courses> coursesOptional = courseRepository.findById(idRequest.getId());
            if(coursesOptional.isEmpty()){
                return ResponseEntity.notFound().build();
            }

            Courses courses = coursesOptional.get();

            System.out.println(courses);

            return ResponseEntity.ok(courses);
        }
        catch(Exception e){
            return ResponseEntity.status(500).body("Internal Server Error");
        }
    }



}
