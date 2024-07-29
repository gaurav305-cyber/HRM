package com.test.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.model.Department;
import com.test.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private List<Department> departmentList = new ArrayList<>();
    @Autowired 
    private DepartmentRepository departmentRepo;
	 @Override
	    public List<Department> getAllDepartments() {
	        return departmentRepo.findAll();
	    }

	    @Override
	    public Department getDepartmentById(String id) {
	        Optional<Department> department = departmentRepo.findById(id);
	        return department.orElse(null);
	    }

	    @Override
	    public Department createDepartment(Department department) {
	        return departmentRepo.save(department);
	    }

	    @Override
	    public Department updateDepartment(String id, Department department) {
	        Optional<Department> existingDepartmentOptional = departmentRepo.findById(id);
	        if (existingDepartmentOptional.isPresent()) {
	            Department existingDepartment = existingDepartmentOptional.get();
	            existingDepartment.setName(department.getName());
	            return departmentRepo.save(existingDepartment);
	        }
	        return null;
	    }

	    @Override
	    public void deleteDepartment(String id) {
	        departmentRepo.deleteById(id);
	    }
}