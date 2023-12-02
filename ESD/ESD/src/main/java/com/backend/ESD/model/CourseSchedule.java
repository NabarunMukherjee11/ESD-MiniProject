package com.backend.ESD.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name="courseSchedule" )
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CourseSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "schedule_id")
    private int id;

    @Column(name = "time", nullable = false)
    private String time;

    @Column(name = "day", nullable = false)
    private String day;

    @Column(name = "room", nullable = false)
    private String room;

    @Column(name = "building", nullable = false)
    private String building;

    @ManyToOne()
    @JoinColumn(name="course_id")
    @JsonIgnore
    private Courses courses;
}
