package com.jshen.crudjpa.service;

import com.jshen.crudjpa.dao.EmployeeRepository;
import com.jshen.crudjpa.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository){
        employeeRepository = theEmployeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int theId) {
        //return employeeRepository.findById(theId); // this might caused an error called "optional" since it might not find the employee
        //so we need to adjust the code as below

        Optional<Employee> result = employeeRepository.findById(theId);

        Employee employee = null;

        if(result.isPresent()){
            employee = result.get();
        } else {
            throw new RuntimeException("Did not find employee with id - " + theId);
        }

        return employee;
    }

    @Override
    public void save(Employee theEmployee) {
        employeeRepository.save(theEmployee);
    }

    @Override
    public void deleteById(int theId) {
        employeeRepository.deleteById(theId);
    }
}
