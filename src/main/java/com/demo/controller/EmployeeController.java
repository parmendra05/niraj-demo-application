package com.demo.controller;

import com.demo.entity.Employee;
import com.demo.service.EmployeeService;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @PostMapping("/save")
    public Employee saveEmployee(@RequestBody Employee employee){
        System.out.println("Called Controller");
        return service.saveEmployee(employee);
    }

    @GetMapping("/get/{id}")
    public Employee getEmployeeById(@PathVariable Integer id){
        return service.getEmployeeById(id);
    }

    @GetMapping("/getAll")
    public List<Employee> getAllEmployee(){
        return service.getAllEmployee();
    }

    @PutMapping("/update/{id}")
    public Employee saveEmployee(@RequestBody Employee employee, @PathVariable Integer id) throws BadRequestException {

        return service.updateEmployee(employee,id);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteEmployeeById(@PathVariable Integer id){
        return service.deleteEmployee(id);
    }

}
