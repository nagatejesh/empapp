package com.nbc.empapp.service;

import com.nbc.empapp.dao.EmployeeRepo;
import com.nbc.empapp.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeSrvImpl implements EmployeeSrv{

    private final EmployeeRepo employeeRepo;

    @Autowired
    public EmployeeSrvImpl(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepo.deleteById(id);
    }

    @Override
    public Employee findById(Long id) {
        return employeeRepo.findById(id).get();
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepo.findAll();
    }
}
