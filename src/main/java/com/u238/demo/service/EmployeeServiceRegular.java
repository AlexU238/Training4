package com.u238.demo.service;

import com.u238.demo.entity.Employee;

import java.util.List;

public interface EmployeeServiceRegular {

    List findAll();

    Employee findById(int id);

    void save(Employee employee);

    void deleteById(int id);
}
