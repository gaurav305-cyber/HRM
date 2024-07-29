package com.test.service;

import java.util.List;

import com.test.model.Employee;
import com.test.model.EmployeeDTO;
import com.test.model.External.Department;

public interface EmployeeService {
    List<Employee> getAllEmployees();
    Employee getEmployeeById(String id);
    Employee createEmployee(Employee employee);
    Employee updateEmployee(String id, Employee employee);
    void deleteEmployee(String id);
    List<EmployeeDTO> getAllEmployeeData(); 
}
