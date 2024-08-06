package com.test.model.External;

public class Payroll {

	private String id;
    private String employeeId;
    private Double amount;
	public Payroll(String id, String employeeId, Double amount) {
		super();
		this.id = id;
		this.employeeId = employeeId;
		this.amount = amount;
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
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
}
