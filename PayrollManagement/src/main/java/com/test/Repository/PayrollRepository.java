package com.test.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.test.model.Payroll;

public interface PayrollRepository extends MongoRepository<Payroll,String>{
	Payroll findByEmployeeId(String employeeId);
}
