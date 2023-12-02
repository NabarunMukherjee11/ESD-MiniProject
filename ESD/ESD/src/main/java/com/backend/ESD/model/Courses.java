package com.backend.ESD.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity(name="Courses")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Courses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private int id;

    @Column(name = "course_code", nullable = false, unique = true)
    private String courseCode;

    @Column(name = "course_name", nullable = false)
    private String coursName;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "year", nullable = false)
    private int year;

    @Column(name = "term", nullable = false)
    private int term;

    @Column(name = "credits", nullable = false)
    private int credits;

    @Column(name = "capacity", nullable = false)
    private int capacity;


    @ManyToOne()
    @JoinColumn(name="faculty_id")
    @JsonIgnore
    private Employee employee;

    @ManyToMany()
    @JoinTable(
            name="Course_Student",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    private Set<Student> students = new HashSet<>();

    @OneToMany(mappedBy = "courses")
    private Set<CourseSchedule> courseSchedules = new HashSet<>();
}
