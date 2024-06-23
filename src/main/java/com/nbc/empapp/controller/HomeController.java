package com.nbc.empapp.controller;

import com.nbc.empapp.entity.Employee;
import com.nbc.empapp.service.EmployeeSrv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final EmployeeSrv employeeSrv;

    @Autowired
    public HomeController(EmployeeSrv employeeSrv) {
        this.employeeSrv = employeeSrv;
    }

    @GetMapping({"","/","/home"})
    public String goHome(){
        return "home.html";
    }

    @GetMapping("/employees")
    public String allEmployees(Model  model){
        model.addAttribute("employees", employeeSrv.getAllEmployees());
        return "employees.html";
    }
    @GetMapping("/login")
    public String displayLoginPage(){
        return "login.html";
    }

    @GetMapping("/employee/new")
    public String newEmployee(Model model){
        model.addAttribute("employee", new Employee());
        return "new_employee.html";
    }
}
