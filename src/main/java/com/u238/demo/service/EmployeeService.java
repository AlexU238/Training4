package com.u238.demo.service;

import com.u238.demo.dao.EmployeeDAORegular;
import com.u238.demo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class EmployeeService implements EmployeeServiceCustom {

    private EmployeeDAORegular employeeDAO;

    //

    @Autowired
    public EmployeeService(@Qualifier("employeeDAOJpa") EmployeeDAORegular employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    @Transactional
    public List getAll() {
        return employeeDAO.getEmployees();
    }

    @Override
    @Transactional
    public Employee getById(int id) {
        return employeeDAO.getEmployeeById(id);
    }

    @Override
    @Transactional
    public void save(Employee employee) {
        employeeDAO.addEmployee(employee);
    }

    @Override
    @Transactional
    public void delete(int id) {
        employeeDAO.deleteEmployeeById(id);
    }
}
