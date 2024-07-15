package com.test.service;

import java.util.List;

import com.test.model.Attendence;

public interface AttencenceService {
	    List<Attendence> getAllAttendances();
	    Attendence getAttendanceById(Long id);
	    Attendence createAttendance(Attendence attendance);
	    Attendence updateAttendance(Long id, Attendence attendance);
	    void deleteAttendance(Long id);
	    Attendence getAttendanceByEmployeeId(Long id);
}
