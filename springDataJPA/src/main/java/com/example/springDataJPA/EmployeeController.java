package com.example.springDataJPA;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springDataJPA.Repository.Employee;
import com.example.springDataJPA.Repository.EmployeeRepository;

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeRepository empRepo;
	
	@RequestMapping("employees")
	public List<Employee> getEmployees(){
		List<Employee> empList = (List<Employee>) empRepo.findAll();
		return empList;
	}

}
