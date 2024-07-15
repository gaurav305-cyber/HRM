package com.test.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.test.model.Attendence;

@Service
public class AttendenceServiceImpl implements AttencenceService{
	 private List<Attendence> attendanceList = new ArrayList<>();
	 LocalDateTime now = LocalDateTime.now();  
	   private AtomicLong idCounter = new AtomicLong();
	    @Override
	    public List<Attendence> getAllAttendances() {
	        return attendanceList;
	    }

	    @Override
	    public Attendence getAttendanceById(Long id) {
	        return attendanceList.stream().filter(a -> a.getId().equals(id)).findFirst().orElse(null);
	    }

	    @Override
	    public Attendence createAttendance(Attendence attendance) {
	    	attendance.setId(idCounter.incrementAndGet());
	    	attendance.setDate(now);
	        attendanceList.add(attendance);
	        return attendance;
	    }

	    @Override
	    public Attendence updateAttendance(Long id, Attendence attendance) {
	    	Attendence existingAttendance = attendanceList.stream().filter(a -> a.getId().equals(id)).findFirst().orElse(null);
	        if (existingAttendance != null) {
	            existingAttendance.setDate(attendance.getDate());
	            existingAttendance.setStatus(attendance.getStatus());
	        }
	        return existingAttendance;
	    }

	    @Override
	    public void deleteAttendance(Long id) {
	        attendanceList.removeIf(a -> a.getId().equals(id));
	    }
	    
	    @Override
	    public Attendence getAttendanceByEmployeeId(Long id) {
	        return attendanceList.stream().filter(a -> a.getEmployeeId().equals(id)).findFirst().orElse(null);
	    }

}
