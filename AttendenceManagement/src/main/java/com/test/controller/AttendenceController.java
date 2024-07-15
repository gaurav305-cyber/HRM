package com.test.controller;

import com.test.model.Attendence;
import com.test.service.AttencenceService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/attendances")
public class AttendenceController {

	
	 @Autowired 
	 private AttencenceService attendanceService;

	    @GetMapping("/")
	    public List<Attendence> getAllAttendances() {
	        return attendanceService.getAllAttendances();
	    }

	    @GetMapping("/{id}")
	    public Attendence getAttendanceById(@PathVariable Long id) {
	        return attendanceService.getAttendanceById(id);
	    }

	    @PostMapping("/")
	    public Attendence createAttendance(@RequestBody Attendence attendance) {
	        return attendanceService.createAttendance(attendance);
	    }

	    @PutMapping("/{id}")
	    public Attendence updateAttendance(@PathVariable Long id, @RequestBody Attendence attendance) {
	        return attendanceService.updateAttendance(id, attendance);
	    }

	    @DeleteMapping("/{id}")
	    public void deleteAttendance(@PathVariable Long id) {
	        attendanceService.deleteAttendance(id);
	    }
	    @GetMapping("/get/{id}")
	    public Attendence getAttendanceByEmployeeId(@PathVariable Long id) {
	        return attendanceService.getAttendanceByEmployeeId(id);
	    }
}
