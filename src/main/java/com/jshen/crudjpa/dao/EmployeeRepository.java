package com.jshen.crudjpa.dao;

import com.jshen.crudjpa.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    //no need to add code as we extends JpaRepository
    //inside <>, we defined we <model, type of id>
}
