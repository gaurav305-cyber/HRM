package com.test.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.model.Attendence;
import com.test.repository.AttendenceRepository;

@Service
public class AttendenceServiceImpl implements AttencenceService{
	 private List<Attendence> attendanceList = new ArrayList<>();
	 
     @Autowired
	 private AttendenceRepository attendenceRepo;
	 LocalDateTime now = LocalDateTime.now();  
	    @Override
	    public List<Attendence> getAllAttendances() {
	        return attendenceRepo.findAll();
	    }

	    @Override
	    public Attendence getAttendanceById(String id) {
	    	Optional<Attendence> attendence = attendenceRepo.findById(id);
	        return attendence.orElse(null);
	    }

	    @Override
	    public Attendence createAttendance(Attendence attendance) {
	    	attendance.setDate(LocalDateTime.now());
	        return attendenceRepo.save(attendance);
	    }

	    @Override
	    public Attendence updateAttendance(String id, Attendence attendence) {
	    	Optional<Attendence> existingAttendenceOptional = attendenceRepo.findById(id);
	        if (existingAttendenceOptional.isPresent()) {
	            Attendence existingAttendence = existingAttendenceOptional.get();
	            existingAttendence.setDate(attendence.getDate());
	            existingAttendence.setStatus(attendence.getStatus());
	            return attendenceRepo.save(existingAttendence);
	        }
	        return null;
	        }

	    @Override
	    public void deleteAttendance(String id) {
	    	attendenceRepo.deleteById(id);
	    }
	    
	    @Override
	    public Attendence getAttendanceByEmployeeId(String id) {
	    	return attendenceRepo.findByEmployeeId(id);
	    }

}
