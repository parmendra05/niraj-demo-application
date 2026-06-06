package com.demo.service;

import com.demo.entity.Employee;
import com.demo.repository.EmployeeRepository;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository repository;

    @Override
    public Employee saveEmployee(Employee employee) {
        return repository.save(employee);
    }

    @Override
    public Employee getEmployeeById(Integer eid) {
        return repository.findById(eid).orElseThrow (()-> new RuntimeException("Employee Not Fount"));
    }

    @Override
    public List<Employee> getAllEmployee() {
        return repository.findAll();
    }

    @Override
    public Employee updateEmployee(Employee employee, Integer eid) throws BadRequestException {
Employee existing = repository.findById(eid).get();
if(existing.getEid() == employee.getEid() ) return repository.save(employee);
else
    throw new BadRequestException("Wrong Operation");
    }

    @Override
    public String deleteEmployee(Integer eid) {
        repository.deleteById(eid);
        return "Employee Deleted";
    }
}
