package com.test.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.test.model.Employee;
import com.test.model.EmployeeDTO;
import com.test.model.External.Attendence;
import com.test.model.External.Department;
import com.test.model.External.Payroll;
import com.test.repository.EmployeeRepository;
import java.util.function.Function;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;


import org.springframework.web.client.RestTemplate;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	 
	 @Autowired
	private RestTemplate restTemplate;
	 @Autowired
	 private EmployeeRepository employeeRepo;

	    @Override
	    public List<Employee> getAllEmployees() {
	        return employeeRepo.findAll();
	    }

	    @Override
	    public Employee getEmployeeById(String id) {
	        Optional<Employee> employee = employeeRepo.findById(id);
	        return employee.orElse(null);
	    }

	    @Override
	    public Employee createEmployee(Employee employee) {
	        return employeeRepo.save(employee);
	    }

	    @Override
	    public Employee updateEmployee(String id, Employee employee) {
	        Optional<Employee> existingEmployeeOptional = employeeRepo.findById(id);
	        if (existingEmployeeOptional.isPresent()) {
	            Employee existingEmployee = existingEmployeeOptional.get();
	            existingEmployee.setName(employee.getName());
	            existingEmployee.setDepartmentId(employee.getDepartmentId());
	            return employeeRepo.save(existingEmployee);
	        }
	        return null;
	    }

	    @Override
	    public void deleteEmployee(String id) {
	        employeeRepo.deleteById(id);
	    }

	    @Override
	    public List<EmployeeDTO> getAllEmployeeDepartment() {
	    	String departmentManagementUrl = "http://DEPARTMENTMANAGEMENT/departments/get/";

	        List<EmployeeDTO> employees = new ArrayList<>();
	        List<Employee> employeeList = employeeRepo.findAll();
	        for (Employee e : employeeList) {
	            EmployeeDTO em = new EmployeeDTO();
	            em.setEmployeeName(e.getName());
	            Department d = restTemplate.getForObject(departmentManagementUrl+e.getDepartmentId(), Department.class);
	            em.setDepartmentName(d.getName());
	            em.setStatus("Present");
	            em.setSalary(1000.00);
	            employees.add(em);
	        }
	        return employees;
	    }
	    
	    @Override
	    public List<EmployeeDTO> getAllEmployeeDepartments() {
	    	String departmentManagementUrl = "http://DEPARTMENTMANAGEMENT/departments/getAllByID";
	        List<Employee> employeeList = employeeRepo.findAll();
	        
	        String departmentIds = employeeList.stream().map(r -> r.getDepartmentId()).distinct().collect(Collectors.joining(","));
	        HttpEntity<String> departmentRequest = new HttpEntity<String>(departmentIds);
	        List<Department> departments = restTemplate
					.exchange(departmentManagementUrl, HttpMethod.POST, departmentRequest, new ParameterizedTypeReference<List<Department>>() {
					}).getBody();

	        List<EmployeeDTO> employees = Collections.synchronizedList(new ArrayList<>());

	        // Create a thread pool
	        ExecutorService executorService = Executors.newFixedThreadPool(5);
	        for (Employee e : employeeList) {
	        	executorService.submit(() -> {
	                EmployeeDTO em = new EmployeeDTO();
	                em.setEmployeeName(e.getName());
	                String departmentName = departments.stream().filter(u -> u.getId().equals(e.getDepartmentId())).findFirst().get()
	    					.getName();

	                    em.setDepartmentName(departmentName);
	                
	                em.setStatus("Present");
	                em.setSalary(1000.00);
	                employees.add(em);
	            });
	        }
	        executorService.shutdown();
	        try {
	            executorService.awaitTermination(1, TimeUnit.MINUTES);
	        } catch (InterruptedException e) {
	            Thread.currentThread().interrupt();
	            throw new RuntimeException("Error waiting for task completion", e);
	        }

	        return employees;
	    }
	    @Override
	    public List<EmployeeDTO> getAllEmployeeData() {
	        String departmentManagementUrl = "http://DEPARTMENTMANAGEMENT/departments/get/";
	        String payrollManagementUrl = "http://PAYROLLMANAGEMENT/payrolls/get/";
	        String attendanceManagementUrl = "http://ATTENDANCEMANAGEMENT/attendances/get/";

	        List<EmployeeDTO> employees = new ArrayList<>();
	        List<Employee> employeeList = employeeRepo.findAll();
	        for (Employee e : employeeList) {
	            EmployeeDTO em = new EmployeeDTO();
	            em.setEmployeeName(e.getName());
	            Department d = restTemplate.getForObject(departmentManagementUrl + e.getId(), Department.class);
	            em.setDepartmentName(d.getName());
	            Attendence a = restTemplate.getForObject(attendanceManagementUrl + e.getDepartmentId(), Attendence.class);
	            em.setStatus(a.getStatus());
	            Payroll p = restTemplate.getForObject(payrollManagementUrl + e.getId(), Payroll.class);
	            em.setSalary(p.getAmount());
	            employees.add(em);
	        }
	        return employees;
	    }
}
