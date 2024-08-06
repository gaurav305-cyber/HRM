package com.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.test.model.Department;
import com.test.service.DepartmentService;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping
    public List<Department> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    @GetMapping("/get/{id}")
    public Department getDepartmentById(@PathVariable String id) {
        return departmentService.getDepartmentById(id);
    }

    @PostMapping
    public Department createDepartment(@RequestBody Department department) {
        return departmentService.createDepartment(department);
    }

    @PutMapping("/{id}")
    public Department updateDepartment(@PathVariable String id, @RequestBody Department department) {
        return departmentService.updateDepartment(id, department);
    }

    @DeleteMapping("/{id}")
    public void deleteDepartment(@PathVariable String id) {
        departmentService.deleteDepartment(id);
    }
    @PostMapping("/getAllByID")
    public List<Department> getAllDepartmentList(@RequestBody String ids) {
        return departmentService.getDepartmentsByIds(ids);
    }
}