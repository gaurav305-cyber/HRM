package com.test.service;

import org.springframework.stereotype.Service;

import com.test.model.Payroll;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class PayrollServiceImpl implements PayrollService {

    private List<Payroll> payrollList = new ArrayList<>();
    private AtomicLong idCounter = new AtomicLong();
    @Override
    public List<Payroll> getAllPayrolls() {
        return payrollList;
    }

    @Override
    public Payroll getPayrollById(Long id) {
        return payrollList.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public Payroll createPayroll(Payroll payroll) {
    	payroll.setId(idCounter.incrementAndGet());
        payrollList.add(payroll);
        return payroll;
    }

    @Override
    public Payroll updatePayroll(Long id, Payroll payroll) {
        Payroll existingPayroll = payrollList.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
        if (existingPayroll != null) {
            existingPayroll.setEmployeeId(payroll.getEmployeeId());
            existingPayroll.setAmount(payroll.getAmount());
        }
        return existingPayroll;
    }

    @Override
    public void deletePayroll(Long id) {
        payrollList.removeIf(p -> p.getId().equals(id));
    }
    
    @Override
    public Payroll getPayrollByEmployeeId(Long id) {
        return payrollList.stream().filter(p -> p.getEmployeeId().equals(id)).findFirst().orElse(null);
    }

}