package com.test.service;

import java.util.List;

import com.test.model.Payroll;

public interface PayrollService {
    List<Payroll> getAllPayrolls();
    Payroll getPayrollById(Long id);
    Payroll createPayroll(Payroll payroll);
    Payroll updatePayroll(Long id, Payroll payroll);
    void deletePayroll(Long id);
    Payroll getPayrollByEmployeeId(Long id);
}