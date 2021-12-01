package com.u238.demo.service;

import com.u238.demo.entity.Employee;

import java.util.List;

public interface EmployeeServiceCustom {

     List getAll();

     Employee getById(int id);

     void save(Employee employee);

     void delete(int id);
}
