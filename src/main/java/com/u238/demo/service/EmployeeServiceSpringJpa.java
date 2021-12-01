package com.u238.demo.service;

import com.u238.demo.dao.EmployeeRepository;
import com.u238.demo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceSpringJpa implements EmployeeServiceRegular {

    EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceSpringJpa(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    @Override
    public List findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int id) {
        Optional<Employee> result = employeeRepository.findById(id);
        Employee employee = null;
        if (result.isPresent()) {
            employee = result.get();
        } else {
            throw new RuntimeException("No such employee");
        }
        return employee;
    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);

    }

    @Override
    public void deleteById(int id) {
        employeeRepository.deleteById(id);
    }
}
