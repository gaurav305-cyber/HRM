package com.test.service;

import java.util.List;

import com.test.model.Department;

public interface DepartmentService {
    List<Department> getAllDepartments();
    Department getDepartmentById(String id);
    Department createDepartment(Department department);
    Department updateDepartment(String id, Department department);
    void deleteDepartment(String id);
}
