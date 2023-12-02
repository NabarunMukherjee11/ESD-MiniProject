package com.backend.ESD.controller;

import com.backend.ESD.model.Employee;
import com.backend.ESD.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class LoginController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping("/login")
    public String login(@RequestBody Employee loginRequest){
        String email = loginRequest.getEmail();
        int password = loginRequest.getPassword();

        System.out.println(loginRequest);

        Employee employee = employeeRepository.findByEmailAndPassword(email, password);

        System.out.println(employee);

        if(employee != null){
            //Login Success
            return String.valueOf(employee.getId());
        } else {
            //Login failed
            return "fail";
        }
    }
}
