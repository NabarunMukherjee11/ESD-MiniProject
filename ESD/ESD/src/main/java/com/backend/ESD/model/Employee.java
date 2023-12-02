package com.backend.ESD.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity(name="Employee")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="faculty_id")
    private int id;

    @Column(name="fullname", nullable = false)
    private String fullName;

    @Column(name="last_name", nullable = true)
    private String lastName;

    @Column(name="email", nullable = false, unique = true)
    private String email;

    @Column(name="title")
    private String title;

    @Column(name = "department_id")
    private int departmentId;

    @Column(name = "password")
    private int password;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Courses> courses = new HashSet<>();
}
