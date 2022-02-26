package com.star.spring.spring_data_jpa.controller;

import com.star.spring.spring_data_jpa.entity.Employee;
import com.star.spring.spring_data_jpa.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class Controller {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> showAllEmployee() {
        return employeeService.getAllEmployee();
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id) {
        Employee employee = employeeService.getEmployee(id);

        return employee;
    }

    @PostMapping("/employees")
    public Employee addNewEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
        return employee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
        return employee;
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable int id) {
        employeeService.deleteEmployee(id);
        return "Employee with ID = " + id + " was deleted.";
    }

    @GetMapping("/employees/name/{name}")
    public List<Employee> getEmployee(@PathVariable String name) {
        return employeeService.findAllByName(name);
    }
}
