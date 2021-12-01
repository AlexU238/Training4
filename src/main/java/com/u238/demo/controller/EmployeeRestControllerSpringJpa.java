package com.u238.demo.controller;

import com.u238.demo.entity.Employee;
import com.u238.demo.service.EmployeeServiceRegular;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jpa")
public class EmployeeRestControllerSpringJpa {

    EmployeeServiceRegular employeeService;


    @Autowired
    public EmployeeRestControllerSpringJpa(@Qualifier("employeeServiceSpringJpa") EmployeeServiceRegular employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List getEmployees() {
        return employeeService.findAll();
    }

    @GetMapping("/employee/{id}")
    public Employee getEmployee(@PathVariable int id){
        Employee employee = employeeService.findById(id);
        if(employee!=null){
            return employee;
        }else {
            throw new RuntimeException("Not found");
        }
    }

    @PostMapping("/employee")
    public Employee addEmployee(@RequestBody Employee employee){
        employee.setId(0);
        employeeService.save(employee);
        return employee;
    }

    @PutMapping("/employee")
    public Employee updateEmployee(@RequestBody Employee employee){
        employeeService.save(employee);
        return employee;
    }

    @DeleteMapping("/employee/{id}")
    public String deleteEmployee(@PathVariable int id){
        Employee employee = employeeService.findById(id);
        if(employee!=null){
            employeeService.deleteById(id);
            return "Employee deleted";
        }else throw new RuntimeException("Such employee does not exist");

    }
}
