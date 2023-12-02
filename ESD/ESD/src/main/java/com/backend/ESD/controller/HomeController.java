package com.backend.ESD.controller;
import com.backend.ESD.model.Courses;
import com.backend.ESD.model.Employee;
import com.backend.ESD.model.IdRequest;
import com.backend.ESD.repository.CourseRepository;
import com.backend.ESD.repository.EmployeeRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping
@Getter
@Setter
public class HomeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private CourseRepository courseRepository;

    @PostMapping("/home")
    public ResponseEntity<?> getEmployeeDetailsAndCourses(@RequestBody IdRequest idRequest) {
        try {
            System.out.println(idRequest.toString());
            // Fetch employee details
            Optional<Employee> employeeOptional = employeeRepository.findById(idRequest.getId());
            if (employeeOptional.isEmpty()) {
                return ResponseEntity.notFound().build();
            }

            Employee employee = employeeOptional.get();

            System.out.println(employee);

            // Fetch courses taught by the employee

            return ResponseEntity.ok(employee);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Internal Server Error");
        }
    }

    // Define a request object to receive the employee id
//    @Getter
//    static class IdRequest {
//        private int id;
//
//        public void setId(int id) {
//            this.id = id;
//        }
//    }

    // Define a response object to structure the data
    @Getter
    static class EmployeeAndCoursesResponse {
        private Employee employee;
        private List<Courses> courses;

        public EmployeeAndCoursesResponse(Employee employee, List<Courses> courses) {
            this.employee = employee;
            this.courses = courses;
        }

    }
}

