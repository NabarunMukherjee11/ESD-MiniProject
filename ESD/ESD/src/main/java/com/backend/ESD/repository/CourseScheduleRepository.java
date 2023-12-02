package com.backend.ESD.repository;

import com.backend.ESD.model.CourseSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseScheduleRepository extends JpaRepository<CourseSchedule,Integer> {
}
