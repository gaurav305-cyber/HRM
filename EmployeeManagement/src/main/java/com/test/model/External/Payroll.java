package com.test.model.External;

public class Payroll {

	private Long id;
    private Long employeeId;
    private Double amount;
	public Payroll(Long id, Long employeeId, Double amount) {
		super();
		this.id = id;
		this.employeeId = employeeId;
		this.amount = amount;
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
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
}
