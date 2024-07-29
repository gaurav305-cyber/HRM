package com.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.model.Employee;
import com.test.model.EmployeeDTO;
import com.test.model.External.Department;
import com.test.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	 @Autowired
	    private EmployeeService employeeService;

	    @GetMapping
	    public List<Employee> getAllEmployees() {
	        return employeeService.getAllEmployees();
	    }

	    @GetMapping("/{id}")
	    public Employee getEmployeeById(@PathVariable String id) {
	        return employeeService.getEmployeeById(id);
	    }

	    @PostMapping
	    public Employee createEmployee(@RequestBody Employee employee) {
	        return employeeService.createEmployee(employee);
	    }

	    @PutMapping("/{id}")
	    public Employee updateEmployee(@PathVariable String id, @RequestBody Employee employee) {
	        return employeeService.updateEmployee(id, employee);
	    }

	    @DeleteMapping("/{id}")
	    public void deleteEmployee(@PathVariable String id) {
	        employeeService.deleteEmployee(id);
	    }

	    @GetMapping("/get-all-employees")
	    public List<EmployeeDTO> getAllEmployeeData() {
	        return employeeService.getAllEmployeeData();
	    }
}
