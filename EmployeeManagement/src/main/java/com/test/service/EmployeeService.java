package com.test.service;

import java.util.List;

import com.test.model.Employee;
import com.test.model.EmployeeDTO;
import com.test.model.External.Department;

public interface EmployeeService {
    List<Employee> getAllEmployees();
    Employee getEmployeeById(Long id);
    Employee createEmployee(Employee employee);
    Employee updateEmployee(Long id, Employee employee);
    void deleteEmployee(Long id);
    List<EmployeeDTO> getAllEmployeeData(); 
}
