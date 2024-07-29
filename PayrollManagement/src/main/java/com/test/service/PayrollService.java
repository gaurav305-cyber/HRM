package com.test.service;

import java.util.List;

import com.test.model.Payroll;

public interface PayrollService {
    List<Payroll> getAllPayrolls();
    Payroll getPayrollById(String id);
    Payroll createPayroll(Payroll payroll);
    Payroll updatePayroll(String id, Payroll payroll);
    void deletePayroll(String id);
    Payroll getPayrollByEmployeeId(String id);
}