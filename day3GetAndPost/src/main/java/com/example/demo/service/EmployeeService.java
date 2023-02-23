package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	EmployeeRepository repository;
	
	public String addEmployee(Employee employee) {
		repository.save(employee);
		return "Added";
	}
	public List<Employee>getEmployee(){
		return repository.findAll();
	}
}
