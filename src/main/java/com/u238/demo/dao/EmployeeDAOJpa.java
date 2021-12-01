package com.u238.demo.dao;

import com.u238.demo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class EmployeeDAOJpa implements EmployeeDAORegular {

    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOJpa(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> getEmployees() {


        TypedQuery query = entityManager.createQuery("from Employee", Employee.class);

        return query.getResultList();
    }

    @Override
    public Employee getEmployeeById(int id) {

        return entityManager.find(Employee.class,id);
    }

    @Override
    public void addEmployee(Employee employee) {
        Employee employeeDB = entityManager.merge(employee);
        employee.setId(employeeDB.getId());
    }

    @Override
    public void deleteEmployeeById(int id) {
        Query query = entityManager.createQuery("delete from Employee where id=:id");
        query.setParameter("id",id);
        query.executeUpdate();
    }
}
