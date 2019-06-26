package com.jshen.crudjpa.dao;

import com.jshen.crudjpa.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    public List<Employee> findAll();

}
