package com.backend.ESD.controller;

import com.backend.ESD.model.Employee;
import com.backend.ESD.model.Student;
import com.backend.ESD.repository.StudentRepository;
import org.hibernate.tool.schema.internal.StandardUserDefinedTypeExporter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;

    @PostMapping("/student")
    private Student newStudent(@RequestBody Student newStudent){ return studentRepository.save(newStudent);}

    @GetMapping("/student")
    List<Student> getAllStudent(){ return studentRepository.findAll();}

}
