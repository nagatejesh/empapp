package com.nbc.empapp.service;

import com.nbc.empapp.entity.Employee;

import java.util.List;

public interface EmployeeSrv {
    Employee saveEmployee(Employee employee);
    void deleteEmployee(Long id);
    Employee findById(Long id);
    List<Employee> getAllEmployees();

}
