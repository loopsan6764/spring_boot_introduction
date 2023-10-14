package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.service.EmployeeService;

@Controller
@RequestMapping("employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
            
        @GetMapping("/create")
        public String addEmployee(@RequestParam("name") String name
                                  , @RequestParam("department") String department) {
            // データを挿入します
            this.employeeService.insert(name, department);
            // 一覧ページにリダイレクト(後述)します
            return "redirect:/employee/list";
        }
    }