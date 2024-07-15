package com.test.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.test.model.Department;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private List<Department> departmentList = new ArrayList<>();
    private AtomicLong idCounter = new AtomicLong();
    @Override
    public List<Department> getAllDepartments() {
        return departmentList;
    }

    @Override
    public Department getDepartmentById(Long id) {
        return departmentList.stream().filter(dep -> dep.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public Department createDepartment(Department department) {
    	department.setId(idCounter.incrementAndGet());
        departmentList.add(department);
        return department;
    }

    @Override
    public Department updateDepartment(Long id, Department department) {
        Department existingDepartment = departmentList.stream().filter(dep -> dep.getId().equals(id)).findFirst().orElse(null);
        if (existingDepartment != null) {
            existingDepartment.setName(department.getName());
        }
        return existingDepartment;
    }

    @Override
    public void deleteDepartment(Long id) {
        departmentList.removeIf(dep -> dep.getId().equals(id));
    }
}