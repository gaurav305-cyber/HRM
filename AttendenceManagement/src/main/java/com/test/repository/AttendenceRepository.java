package com.test.repository;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.test.model.Attendence;

public interface AttendenceRepository extends MongoRepository<Attendence,String>{
	Attendence findByEmployeeId(String employeeId);
}
