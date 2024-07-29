package com.test.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.test.model.Department;


public interface DepartmentRepository extends MongoRepository<Department,String>{

}
