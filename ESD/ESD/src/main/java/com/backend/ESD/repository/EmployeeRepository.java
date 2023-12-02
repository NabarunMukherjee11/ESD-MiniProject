package com.backend.ESD.repository;

import com.backend.ESD.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee,Integer>{
    Employee findByEmailAndPassword(String email, int password);

}
