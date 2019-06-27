package com.jshen.crudjpa.rest;

import com.jshen.crudjpa.entity.Employee;
import com.jshen.crudjpa.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService theEmployeeService) {
        employeeService = theEmployeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    @GetMapping("/employees/{id}")
    public Employee findById(@PathVariable int id){
        Employee employee = employeeService.findById(id);

        if(employee == null){
            throw new RuntimeException("Did not find employee with id - " + id);
        }
        return employee;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee){
        // also just in case they pass an id in JSON ... set id to 0
        // this is to force a save of new item ... instead of update
        employee.setId(0);
        employeeService.save(employee);
        return employee;
    }

    @PutMapping("/employees/{id}")
    public Employee UpdateEmployee (@RequestBody Employee employee){
        //just for testing, did not add the logic that check if the employee exist;
        employeeService.save(employee);
        return employee;
    }

    @DeleteMapping("employees/{id}")
    public String deleteEmployee(@PathVariable int id){
        Employee employee = employeeService.findById(id);

        if (employee == null) {
            throw new RuntimeException("Employee id not found - " + id);
        }

        employeeService.deleteById(id);
        return "Deleted employee id - " + id;
    }


}
