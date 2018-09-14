package com.example.springDataJPA;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.springDataJPA.Repository.Employee;
import com.example.springDataJPA.Repository.EmployeeRepository;

@SpringBootApplication
public class SpringDataJpaApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaApplication.class, args);
	}
	
	@Autowired
	EmployeeRepository employeeRepo;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Employee e1 = new Employee("Rajesh", "CSE");
		Employee e2 = new Employee("Mahesh", "ECE");
		Employee e3 = new Employee("Ramesh", "EEE");
		employeeRepo.save(e1);
		employeeRepo.save(e2);
		employeeRepo.save(e3);
	}
}
