package com.test.model.External;

import java.time.LocalDateTime;
import java.util.Date;

public class Attendence {
	private String id;
    private String employeeId;
    private LocalDateTime date;
    private String status;
	public Attendence(String id, String employeeId, LocalDateTime date, String status) {
		super();
		this.id = id;
		this.employeeId = employeeId;
		this.date = date;
		this.status = status;
	}
    public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
