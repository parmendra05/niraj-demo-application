package com.demo.service;

import com.demo.entity.Employee;
import org.apache.coyote.BadRequestException;

import java.util.List;

public interface EmployeeService {
    public Employee saveEmployee(Employee employee);

    public Employee getEmployeeById(Integer eid);
    public List<Employee> getAllEmployee();

    public Employee updateEmployee(Employee employee, Integer eid) throws BadRequestException;
    public String deleteEmployee(Integer eid);

}
