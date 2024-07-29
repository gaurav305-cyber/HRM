package com.test.service;

import java.util.List;

import com.test.model.Attendence;

public interface AttencenceService {
	    List<Attendence> getAllAttendances();
	    Attendence getAttendanceById(String id);
	    Attendence createAttendance(Attendence attendance);
	    Attendence updateAttendance(String id, Attendence attendance);
	    void deleteAttendance(String id);
	    Attendence getAttendanceByEmployeeId(String id);
}
