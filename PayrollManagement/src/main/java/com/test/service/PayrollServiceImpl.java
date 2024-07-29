package com.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.Repository.PayrollRepository;
import com.test.model.Payroll;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class PayrollServiceImpl implements PayrollService {

    private List<Payroll> payrollList = new ArrayList<>();
    
    @Autowired
    private PayrollRepository payrollRepo;
    @Override
    public List<Payroll> getAllPayrolls() {
        return payrollRepo.findAll();
    }

    @Override
    public Payroll getPayrollById(String id) {
        Optional<Payroll> payroll = payrollRepo.findById(id);
        return payroll.orElse(null);
    }

    @Override
    public Payroll createPayroll(Payroll payroll) {
        return payrollRepo.save(payroll);
    }

    @Override
    public Payroll updatePayroll(String id, Payroll payroll) {
        Optional<Payroll> existingPayrollOptional = payrollRepo.findById(id);
        if (existingPayrollOptional.isPresent()) {
            Payroll existingPayroll = existingPayrollOptional.get();
            existingPayroll.setEmployeeId(payroll.getEmployeeId());
            existingPayroll.setAmount(payroll.getAmount());
            return payrollRepo.save(existingPayroll);
        }
        return null;
    }

    @Override
    public void deletePayroll(String id) {
        payrollRepo.deleteById(id);
    }

    @Override
    public Payroll getPayrollByEmployeeId(String employeeId) {
        return payrollRepo.findByEmployeeId(employeeId);
    }
}