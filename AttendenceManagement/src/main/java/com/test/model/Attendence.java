package com.test.model;

import java.time.LocalDateTime;
import java.util.Date;

public class Attendence {
	private Long id;
    private Long employeeId;
    private LocalDateTime date;
    private String status;
	public Attendence(Long id, Long employeeId, LocalDateTime date, String status) {
		super();
		this.id = id;
		this.employeeId = employeeId;
		this.date = date;
		this.status = status;
	}
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Long employeeId) {
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
