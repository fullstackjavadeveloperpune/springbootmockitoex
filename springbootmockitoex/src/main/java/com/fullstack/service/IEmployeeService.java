package com.fullstack.service;

import com.fullstack.model.Employee;

import java.util.List;

public interface IEmployeeService {

    Employee save(Employee employee);

    List<Employee> findAll();

    Employee update(Employee employee);

    void deleteById(int empId);
}
