package com.test.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.model.Employee;
import com.test.model.EmployeeDTO;
import com.test.model.External.Attendence;
import com.test.model.External.Department;
import com.test.model.External.Payroll;

import org.springframework.web.client.RestTemplate;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	 
	 @Autowired
	private RestTemplate restTemplate;
	 
	 private AtomicLong idCounter = new AtomicLong();
	    private List<Employee> employeeList = new ArrayList<>();

	    @Override
	    public List<Employee> getAllEmployees() {
	        return employeeList;
	    }

	    @Override
	    public Employee getEmployeeById(Long id) {
	        return employeeList.stream().filter(emp -> emp.getId().equals(id)).findFirst().orElse(null);
	    }

	    @Override
	    public Employee createEmployee(Employee employee) {
	    	employee.setId(idCounter.incrementAndGet());
	        employeeList.add(employee);
	        return employee;
	    }

	    @Override
	    public Employee updateEmployee(Long id, Employee employee) {
	        Employee existingEmployee = employeeList.stream().filter(emp -> emp.getId().equals(id)).findFirst().orElse(null);
	        if (existingEmployee != null) {
	            existingEmployee.setName(employee.getName());
	            existingEmployee.setDepartmentId(employee.getDepartmentId());
	        }
	        return existingEmployee;
	    }

	    @Override
	    public void deleteEmployee(Long id) {
	        employeeList.removeIf(emp -> emp.getId().equals(id));
	    }

	    @Override
	    public List<EmployeeDTO> getAllEmployeeData() {
	    	String departmentManagementeUrl = "http://DEPARTMENTMANAGEMENT/departments/get/";
	    	String payrollManagementUrl = "http://PAYROLLMANAGEMENT/payrolls/get/";
	    	String attendenceManagementUrl = "http://ATTENDENCEMANAGEMENT/attendances/get/";
	    	
	    	List<EmployeeDTO> employees=new ArrayList<>();
	    	for(Employee e: employeeList) {
	    		EmployeeDTO em=new EmployeeDTO();
	    		em.setEmployeeName(e.getName());
	    		Department d=restTemplate.getForObject(departmentManagementeUrl + e.getId(), Department.class);
	    		em.setDepartmentName(d.getName());
	    		Attendence a=restTemplate.getForObject(attendenceManagementUrl + e.getDepartmentId(), Attendence.class);
	    		em.setStatus(a.getStatus());
	    		Payroll p=restTemplate.getForObject(payrollManagementUrl + e.getId(), Payroll.class);
	    		em.setSalary(p.getAmount());	    		
	    		employees.add(em);
	    	}
	    	return employees;
	    }
}
