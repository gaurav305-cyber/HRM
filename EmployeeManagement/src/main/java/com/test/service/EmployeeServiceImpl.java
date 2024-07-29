package com.test.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.model.Employee;
import com.test.model.EmployeeDTO;
import com.test.model.External.Attendence;
import com.test.model.External.Department;
import com.test.model.External.Payroll;
import com.test.repository.EmployeeRepository;

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
