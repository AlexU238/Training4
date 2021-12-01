package com.u238.demo.dao;

import com.u238.demo.entity.Employee;

import java.util.List;

public interface EmployeeDAORegular {

     List<Employee>getEmployees();

     Employee getEmployeeById(int id);

     void addEmployee(Employee employee);

     void deleteEmployeeById(int id);


}
