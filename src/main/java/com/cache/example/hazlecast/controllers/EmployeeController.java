package com.cache.example.hazlecast.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cache.example.hazlecast.models.Employee;
import com.cache.example.hazlecast.services.EmployeeService;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    EmployeeController (EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(value = "/all")
    public List<Employee> getAllUsers() {
        return employeeService.findAll();
    }
    @PutMapping(value = "/place/{place}/salary/{percentage}")
    public List<Employee> update(@PathVariable("place") String employeePlace ,@PathVariable("percentage") double percentInc) {
    	employeeService.updateEmployee(employeePlace,percentInc);
        return employeeService.findAll();
    }
}