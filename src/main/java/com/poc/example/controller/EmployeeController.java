package com.poc.example.controller;

import com.poc.example.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;


}
