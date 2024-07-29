package com.test.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.test.model.Employee;

public interface EmployeeRepository extends MongoRepository<Employee,String> {

}
